<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="js/jquery1.8.2.min.js"></script>  	    
	<title>My JSP 'index.jsp' starting page</title>	
	<script type="text/javascript">
		$(function(){
	   		$("#Ajax").click(function(){
				$.ajax({
					type: "POST",
					url: 'http://localhost:8080/Blog/quXiaodianZanJianYi.form',
					dataType: "json",
					async: false,
					scriptCharset: 'utf-8',
					data: {
						jYId:2,						
						ip:'121.91.0.1'
					},
					success:function (json) {							
						alert("成功"+json[0].message+json[0].status);						
					}
				});
			});
		});
	</script>
  </head>
  
  <body>    
		<input id="Ajax" type="button" value="AJAX测试"/>
   		<div id="show" >
   			取消点赞
 		</div> 
  </body>
</html>
