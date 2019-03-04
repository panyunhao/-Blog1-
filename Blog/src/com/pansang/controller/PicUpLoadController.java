package com.pansang.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pansang.entity.*;
import com.pansang.service.*;

@Controller
@RequestMapping("/")
public class PicUpLoadController {
	@Autowired
	FuJianService fjs;

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String picUpLoad(HttpServletRequest request,HttpSession session, HttpServletResponse response)throws IOException, FileUploadException {

		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String tempPath = "E:/projectBeiFen/pic";
		File tempFile = new File(tempPath);
		// 判断上传文件的保存目录是否存在
		if (!tempFile.exists()) {
			// 创建目录
			tempFile.mkdir();
		}
		List<String> list=new ArrayList<String>();
		try{
			request.setCharacterEncoding("UTF-8");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//			Map<String, MultipartFile> fileList = multipartRequest.getFileMap();
			List<MultipartFile> fileList= multipartRequest.getFiles("myFile");
			if(fileList!=null&&fileList.size()!=0){
//				for (Map.Entry<String, MultipartFile> me : fileList.entrySet()) {
//					MultipartFile file =me.getValue();
				for (MultipartFile file : fileList) {									
					//获取文件名
					String fileName=file.getOriginalFilename();
//					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					fileName =new Date().getTime()+"-" + Math.random()*10000 + fileName.substring(fileName.lastIndexOf("."));
//					fileName=new Date().getTime()+"-"+fileName;
															
			   		file.transferTo(new File(tempPath+"/"+fileName));
//			   		String url="http://39.106.137.129/upload/pic/"+fileName;
			   		String url=request.getScheme() + "://" + request.getServerName()
							+ ":" + request.getServerPort() + "/upload/pic/" + fileName;
			   		list.add(url);		    		
				}
			}
			WangEditor we = new WangEditor(list);
//			System.out.println("{\"errno\":0, \"data\":[\"http://localhost:8080/upload/temp/92b88b5494eef01f110e107ee1fe9925bc317d2d.jpg\"]}");
			System.out.println(we.toString());
			return we.toString();
					    				    		
		}catch (Exception e) {
			return "{\"errno\":" + 1 + ", \"data\":\"出现未知异常\" ]}";	
		}
	
	}

}
