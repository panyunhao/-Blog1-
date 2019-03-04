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
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
    <title>My JSP 'index.jsp' starting page</title>	
  </head>
  
  <body>
   	<!-- body container -->
	<div class="container">
	        <div style="max-width:1100px;">
	            <!--demo-->
	            <div style="text-align:left;">
	                <div id="divDemo"><p>欢迎使用<b>wangEditor 富文本编辑器</b>，请输入内容...</p></div>
	            </div><!--demo end-->
	        </div>
	</div><!-- body container end -->
	<input class="input-xlarge focused" name="info" type="text" id="info" >
	 
	 <script type="text/javascript">
  	$(function (){
	    var E = window.wangEditor;
	    var editor = new E('#divDemo');
	    editor.customConfig.uploadImgShowBase64 = true;
	    // 上传图片到服务器
		editor.customConfig.uploadFileName = 'myFile'; //设置文件上传的参数名称
		editor.customConfig.uploadImgServer = 'upload.form'; //设置上传文件的服务器路径
		editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024; // 将图片大小限制为 10M
		editor.customConfig.uploadImgMaxLength = 30;// 限制一次最多上传 5 张图片
		//自定义上传图片事件
		editor.customConfig.uploadImgHooks = {
			before : function(xhr, editor, files) {	
							
			},
			success : function(xhr, editor, result) {
				console.log("上传成功");
			},
			fail : function(xhr, editor, result) {
				console.log("上传失败,原因是"+result);
			},
			error : function(xhr, editor) {
				console.log("上传出错");
			},
			timeout : function(xhr, editor) {
				console.log("上传超时");
			}
		};
	    editor.create();
	});
  	
  		document.getElementById('info').addEventListener('click', function () {
	    	// 读取 html
	    	var info = editor1.txt.html();
	
	    	document.getElementById("info").value=info;
	
		  }, false);

  </script>
	<script type="text/javascript" src='js/wangEditor.min.js'></script>	    
    
  </body>
</html>
