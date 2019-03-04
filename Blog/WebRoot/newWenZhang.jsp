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
					url: 'http://localhost:8080/Blog/insertWenZhang.form',
					dataType: "json",
					async: false,
					scriptCharset: 'utf-8',
					data: {
						wZTitle:'文章12ffxxx544方法',
						headImg:'E:/projectBeiFen/12/0/e21bf6a2-5067-4965-aaab-b984802e223c_[Hakurei]_X113_022.png',
						wZText:'全部fewfq新的期望的湖南我IDhi哦吼呵护旗舰店那不就全部放弃我博发布请问fvewqfqfwe吃葡萄不吐葡萄皮，不吃葡萄到图葡萄皮，吃葡萄不吐葡萄皮，不吃222222222222222312323',
						WZJJ:'李小1564sfrx',
						YC:1,
						wZurl:'',
						biaoQian:'Oracle'
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
   			新增文章
 		</div> 
  </body>
</html>
