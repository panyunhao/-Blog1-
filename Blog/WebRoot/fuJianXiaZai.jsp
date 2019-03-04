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
  </head>
  
  <body>    
   		<div id="show" >
   			下载附件   			
   			<form action="http://localhost:8080/Blog/fuJianXiaZai.form" method="post">
   				<input type="text" name="fJId" value="5">
   				<input type="submit" value="post请求下载" />
   			</form>
 		</div> 
  </body>
</html>
