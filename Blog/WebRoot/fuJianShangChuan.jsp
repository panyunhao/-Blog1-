<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>       
    <title>FuJian</title>	
  </head>
  
  <body>
	<form action="fuJianShangChuan1.form" enctype="multipart/form-data" method="post">
         上传用户：<input type="text" name="username"><br/>
         上传文件1：<input type="file" name="file1"><br/>
         上传文件2：<input type="file" name="file2"><br/>
         <input type="submit" value="提交">
     </form>
  </body>
</html>
