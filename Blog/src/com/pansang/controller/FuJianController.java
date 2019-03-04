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

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;

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
public class FuJianController {
	@Autowired	
	FuJianService fjs;
	
	@ResponseBody
	@RequestMapping(value = "/fuJianShangChuan",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String fuJianShangChuan1(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException, FileUploadException{				
								
		String tempPath = "C:/projectBeiFen/fuJian";
		File tempFile = new File(tempPath);
		//判断上传文件的保存目录是否存在
		if (!tempFile.exists()) {
			//创建目录
			tempFile.mkdir();
		}
		String wenjianurl="[";
		try{
			List list =new ArrayList();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileList = multipartRequest.getFileMap();
			if(fileList!=null&&fileList.size()!=0){
				for (Map.Entry<String, MultipartFile> me : fileList.entrySet()) {
					MultipartFile file =me.getValue();
					//获取文件名
					String fileName=file.getOriginalFilename();
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					fileName=new Date().getTime()+"-"+fileName;
					//获取文件大小
					long fileSize=file.getSize();
					if(fileSize>=5242880){
						return "{\"errno\":" + 1 + ",\"data\":\"暂不支持超过50M以上文件\", \"data\":" + wenjianurl + "]}";
					}
					//获取文件类型
					String contentType = file.getContentType();
					System.out.println("这是"+contentType+"类型文件");
					//获取文件内容
	//				byte[] fileByte =file.getBytes();					
			   		file.transferTo(new File(tempPath+"/"+fileName));
			   		String url="http://39.106.137.129\\upload\\fuJian\\"+fileName;
			   		list.add(url);		    		
				}
			}
			wenjianurl="[";
			for (int i = 0; i < list.size(); i++) {
				if(i==0){				
					wenjianurl=wenjianurl+"\""+list.get(0)+"\"";
				}else{
					wenjianurl=wenjianurl+",\""+list.get(i)+"\"";
				}
			}					
			return "{\"errno\":" + 0 + ", \"data\":" + wenjianurl + "]}";		    				    		
		}catch (Exception e) {
			return "{\"errno\":" + 1 + ",\"data\":\"出现异常\", \"data\":" + wenjianurl + "]}";
		}
	}
		
	}
	
