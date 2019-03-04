package com.pansang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pansang.entity.*;
import com.pansang.service.*;

@Controller
@RequestMapping("/")
public class JianYiController {
	@Autowired	
	JianYiService jys;
	@Autowired	
	FangKeService fks;
	@Autowired	
	DianZanService dzs;
	
	@ResponseBody
	@RequestMapping(value = "/insertJianYi",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String insertJianYi(HttpServletRequest request,HttpSession session,HttpServletResponse response,
		@RequestParam(value="fKName",required = true) String fKName,
		@RequestParam(value="head",required = false) String head,
		@RequestParam(value="email",required = true) String email,			
		@RequestParam(value="lYText",required = true) String lYText,
		@RequestParam(value="ip",required = true) String dqIp) {
		//判断访客是否存在
		FangKe fk=fks.selectFangKeByIP(dqIp);
		int date1=0;
		int date2=0;
		if(fk==null){
			System.out.println("新IP访客登录");
			FangKe newFK=new FangKe();
			newFK.setfKName(fKName);
			newFK.setHead(head);
			newFK.setEmail(email);
			newFK.setFKIP(dqIp);			
			date1=fks.insertFangKe(newFK);
		}
		//新增建议
		JianYi newJY=new JianYi();
		newJY.setUsName(fKName);
		newJY.setHead(head);
		newJY.setEmail(email);
		newJY.setlYText(lYText);
		date2=jys.insertJianYi(newJY);				
		System.out.println("返回的主键值是"+newJY.getjYId()); 
		Map outmap=new HashMap();
		if(date2>0){			
			outmap.put("state", "1");
			outmap.put("message", "建议新增成功");
		}else{
			outmap.put("state", "0");
			outmap.put("message", "建议新增失败");
		}
		return reJson(outmap);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectJianYiFenYe",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String selectJianYiFenYe(HttpServletRequest request,HttpSession session,HttpServletResponse response,			
		@RequestParam(value="dqy",required = true,defaultValue="1") int dqy,		
		@RequestParam(value="ip",required = true) String dqIp) {
		Map outmap=new HashMap();
		if(dqIp==null){
			outmap.put("state", "没IP查个鸡儿");			
			System.out.println("没IP查个鸡儿");
			return reJson(outmap);
		}
		//进入建议分页查询方法
		System.out.println("进入建议分页查询方法");
		Map mapInt=new HashMap();		
		mapInt.put("begin1", dqy*10-9);
		mapInt.put("end1", dqy*10);
		List<JianYi> jyl=jys.selectJianYiFenYe(mapInt);
		List<JianYi> newJYL=new ArrayList<JianYi>();
		//查询当前用户是否点过赞并在qt1中显示：1 点赞；0未点赞
		for (int i = 0; i < jyl.size(); i++) {
			JianYi jy=jyl.get(i);
			FangKe fk=fks.selectFangKeByIP(dqIp);
			DianZan dz=new DianZan();
			dz.setjYId(jy.getjYId());
			dz.setDZIP(dqIp);
			DianZan state=dzs.selectDianZanState(dz);
			if(state!=null&&state.getState()==1){
				jy.setState(1);
			}
			newJYL.add(jy);
		}
		
		int num=jys.selectJianYiNum();
		//输出建议列表以及建议数量
		outmap.put("JYLS", newJYL);
		outmap.put("num", num);
		return reJson(outmap);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/dianZanJianYi",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String dianZanJianYi(HttpServletRequest request,HttpSession session,HttpServletResponse response,			
		@RequestParam(value="jYId",required = true) int jYId,
		@RequestParam(value="ip",required = false) String dqIp) {
		//进入建议分页查询方法
		System.out.println("进入建议点赞方法");
		Map outmap=new HashMap();
		if(dqIp==null){
			outmap.put("state", "0");
			outmap.put("message", "没IP点个鸡儿");
			System.out.println("没IP点个鸡儿");
			return reJson(outmap);
		}		
		//查询点赞状态
		DianZan dz=new DianZan();
		dz.setjYId(jYId);
		dz.setDZIP(dqIp);
		DianZan olddz =dzs.selectDianZanState(dz);
		int date=0;
		if(olddz==null){
			jys.dianZanJianYi(jYId);
			date=dzs.insertDianZan(dz);
		}else if(olddz.getState()!=1){
			//建议赞+1
			jys.dianZanJianYi(jYId);
			//新增点赞记录
			dz.setState(1);
			date=dzs.updatedianZanState(dz);
		}
		if(date!=0){
			outmap.put("state", "1");
			outmap.put("message", "点赞成功");
		}else{
			outmap.put("state", "0");
			outmap.put("message", "点赞记录添加失败");			
		}
		//输出建议列表以及建议数量
		return reJson(outmap);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/quXiaodianZanJianYi",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String quXiaodianZanJianYi(HttpServletRequest request,HttpSession session,HttpServletResponse response,			
			@RequestParam(value="jYId",required = true) int jYId,				
			@RequestParam(value="ip",required = false) String dqIp) {
			//进入建议分页查询方法
			System.out.println("进入建议取消点赞方法");
			Map outmap=new HashMap();
			if(dqIp==null){
				outmap.put("state", "0");
				outmap.put("message", "没IP点个鸡儿");			
				System.out.println("没IP点个鸡儿");
				return reJson(outmap);
			}		
			//查询点赞状态
			DianZan dz=new DianZan();
			dz.setjYId(jYId);
			dz.setDZIP(dqIp);
			DianZan olddz =dzs.selectDianZanState(dz);
			int date=0;			
			if(olddz!=null&&olddz.getState()==1){
				//建议赞-1
				jys.quXiaodianZanJianYi(jYId);
				//修改点赞记录变成不点赞状态
				dz.setState(2);				
				date=dzs.updatedianZanState(dz);
			}
			
			if(date!=0){
				outmap.put("state", "1");
				outmap.put("message", "取消点赞成功");
			}else{
				outmap.put("state", "0");
				outmap.put("message", "取消点赞失败");			
			}
			//输出修改结果
			return reJson(outmap);
	}		
	
	public String reJson(Map map){
		JSONArray arr=JSONArray.fromObject(map);		
		String json1=arr.toString();
		String json2=json1.substring(1, json1.length()-1);
		System.out.println("Map_json:"+json2);
		return json2;	
	}
	
	public String reJson(List list){
		JSONArray arr=JSONArray.fromObject(list);		
		String json1=arr.toString();
		String json2=json1.substring(1, json1.length()-1);
		System.out.println("List_json:"+json2);
		return json2;	
	}
	
}

