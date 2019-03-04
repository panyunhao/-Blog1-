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
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery1.8.2.min.js"></script> 
    <title>My JSP 'index.jsp' starting page</title>
	<script type="text/javascript">
		$(function(){
	   		$("#Ajax").click(function(){	   			
				$.ajax({
					type: "POST",
					url: 'http://localhost:8080/Blog/updateWenZhang.form',
					dataType: "json",
					async: false,
					scriptCharset: 'utf-8',
					data: {
						wZId:1,
						wZTitle:'xxxxxxxsssssaaqwdq',
						wZText:'文章内容嘻嘻嘻121221寻寻寻群无费覅偶借钱我佛微积分',
						WZJJ:'文章简介咔咔咔咔咔咔扩扩扩扩扩扩',
						wZState:2,
						YC:1,
						wZurl:'www.4399.com',
						see:2,
						biaoQian:'JAVA;前台;后台'
					},
					success:function (json) {							
						alert("成功"+json[0].WZJJ+json[0].wZText);						
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <table>
    	<tr>   		
    		<td><input type="button" value="修盖"  id="Ajax"> </td>
    	</tr>
    </table>
    <div id="show">
    </div>
    
  </body>
</html>
