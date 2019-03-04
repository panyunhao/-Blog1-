package com.pansang.entity;

import java.util.Arrays;
import java.util.List;

public class WangEditor {
	private Integer errno; //错误代码，0 表示没有错误。
	private String[] data; //已上传的图片路径
	
	public WangEditor() {
		super();
	}
	public WangEditor(String[] data) {
		super();
		this.errno = 0;
		this.data = data;
	}
	public WangEditor(List  list) {
		super();
		this.errno = 0;
		String[] strings = new String[list.size()];		
		this.data = (String[]) list.toArray(strings);
	}
	public Integer getErrno() {
		return errno;
	}
	public void setErrno(Integer errno) {
		this.errno = errno;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		//"{\"errno\":0, \"data\":[\"http://localhost:8080/upload/temp/92b88b5494eef01f110e107ee1fe9925bc317d2d.jpg\"]}"
		String str="[";
		for (int i = 0; i < data.length; i++) {
			if(i==0){				
				str=str+"\""+data[i]+"\"";
			}else{
				str=str+",\""+data[i]+"\"";
			}
		}
		str=str+"]";
		return "{\"errno\":" + errno + ", \"data\":" + str + "}";
	}

}
