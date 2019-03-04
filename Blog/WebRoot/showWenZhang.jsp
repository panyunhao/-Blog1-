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
					url: 'http://localhost:8080/Blog/selectWenZhangById.form',
					dataType: "json",
					async: false,
					scriptCharset: 'utf-8',
					data: {
						wZId:21						
					},
					success:function (json) {							
						alert("成功"+json.dqwz.WZJJ+json.dqwz.wZText);						
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <table>
    	<tr>
    		<td><input type="text" name="wZId" id="wZId" value="xx"> </td>
    		<td><input type="button" value="查询"  id="Ajax"> </td>
    	</tr>
    </table>
    <div id="show">
    	查询单ID对象文章
    </div>
    
    
  </body>
</html>
