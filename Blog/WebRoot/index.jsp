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
    <title>showList</title>
  </head>
  
  <body>
    ${dqusers.name} 欢迎~
    <form:form modelAttribute="wenZhangList" action="showWenZhangList.form">
	<table class="">
        <tr>
            <th>输入标签：</th>
            <td>
                <input id="biaoQian" type="text" value=""  name="biaoQian" onclick="this.value=''"/>
            </td>
        </tr>
        <tr>            
            <td>
            	<input type="submit" value="登 录" class="" style="">             	            	            	            		
            </td>
        </tr>       
    </table>
	</form:form>
  </body>
</html>
