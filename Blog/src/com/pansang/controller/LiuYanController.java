package com.pansang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pansang.entity.*;
import com.pansang.service.*;

@Controller
@RequestMapping("/")
public class LiuYanController {
	@Autowired	
	LiuYanService lys;
	@Autowired	
	FangKeService fks;
	@Autowired	
	DianZanService dzs;
	
	@ResponseBody
	@RequestMapping(value = "/selectLiuYanFenYe",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String selectLiuYanFenYe(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="wZId",required = true) int wZId,
			@RequestParam(value="ip",required = true) String dqIp,
			@RequestParam(value="lydqy",required = true,defaultValue= "1" ) int lydqy) {
		System.out.println("当前留言页码:"+lydqy);
		Map outmap=new HashMap();
		if(dqIp==null){
			outmap.put("state", "0");
			outmap.put("message", "没IP取消个鸡儿");			
			System.out.println("没IP查个鸡儿");
			return reJson(outmap);
		}
		//查询留言
		System.out.println("进入留言分页查询方法");
		Map map=new HashMap();
		map.put("begin1", lydqy*10-9);
		map.put("end1", lydqy*10);
		map.put("wZId", wZId);
		//分页查询十条留言
		List<LiuYan> liuyanlist=lys.selectLiuYanFenYe(map);
		List<LiuYan> newLiuYanList=new ArrayList<LiuYan>();
		//循环查询二层留言并传入
		//查询当前用户是否点过赞并在qt1中显示：1 点赞；0未点赞
		for (int i = 0; i < liuyanlist.size(); i++) {
			LiuYan ly=liuyanlist.get(i);
			//通过IP查询访客
//			FangKe fk=fks.selectFangKeByIP(dqIp);
			DianZan dz=new DianZan();
			dz.setlYId(ly.getlYId());
			dz.setDZIP(dqIp);
			DianZan oldDz=dzs.selectDianZanState(dz);
			//传入留言记录点赞状态到qt2
			if(oldDz!=null&&oldDz.getState()==1){
				ly.setState(1);
			}			
			map.put("lYId", ly.getlYId());
			//传入二层留言
			ly.setLylist(lys.selectLiuYanMore(map));
			newLiuYanList.add(ly);
		}
		int num = lys.selectLiuYanNumByWZId(wZId);
		outmap.put("dqlyl", newLiuYanList);
		outmap.put("num", num);
		return reJson(outmap);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/insertLiuYan",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String insertLiuYan(HttpServletRequest request,HttpSession session,HttpServletResponse response,
		@RequestParam(value="wZId",required = true) int wZId,
		@RequestParam(value="fKName",required = true) String fKName,
		@RequestParam(value="head",required = true) String head,
		@RequestParam(value="fId",required = false) int fId,
		@RequestParam(value="email",required = true) String email,			
		@RequestParam(value="lYText",required = true) String lYText,
		@RequestParam(value="ip",required = true) String dqIp) {
		//判断访客是否存在
		FangKe fk=fks.selectFangKeByIP(dqIp);
		int dqfkId=0;
		int newLyId=0;
		if(fk==null){
			System.out.println("新IP访客登录");
			FangKe newFK=new FangKe();
			newFK.setfKName(fKName);
			newFK.setHead(head);
			newFK.setEmail(email);
			newFK.setFKIP(dqIp);			
			dqfkId=fks.insertFangKe(newFK);
			System.out.println("当前新访客新增ID:"+dqfkId);
		}else{
			dqfkId=fk.getfKId();
			System.out.println("当前是旧访客ID为:"+dqfkId);
		}
		//新增留言
		LiuYan newLY=new LiuYan();
		newLY.setwZId(wZId);		
		newLY.setfId(fId);		
		newLY.setfKId(dqfkId);		
		newLY.setfKName(fKName);
		newLY.setHead(head);
		newLY.setlYText(lYText);
		newLyId=lys.insertLiuYan(newLY);		
		Map outmap=new HashMap();
		if(newLyId>0){			
			outmap.put("state", "1");
			outmap.put("message", "新增留言成功");				
		}else{
			outmap.put("state", "0");
			outmap.put("message", "新增留言失败");
		}				
		return reJson(outmap);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/dianZanLiuYan",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String dianZanLiuYan(HttpServletRequest request,HttpSession session,HttpServletResponse response,			
		@RequestParam(value="lYId",required = true) int lYId,		
		@RequestParam(value="ip",required = true) String dqIp) {
		//进入建议分页查询方法
		System.out.println("进入留言点赞方法");
		Map outmap=new HashMap();
		if(dqIp==null){
			outmap.put("state", "0");
			outmap.put("message", "没IP点个鸡儿");			
			System.out.println("没IP点个鸡儿");
			return reJson(outmap);
		}		
		//查询点赞状态
		DianZan dz=new DianZan();
		dz.setlYId(lYId);
		dz.setDZIP(dqIp);
		DianZan olddz=dzs.selectDianZanState(dz);
		int date=0;
		if(olddz==null){
			//建议赞+1
			lys.dianZanLiuYan(lYId);
			//新增点赞记录
			date=dzs.insertDianZan(dz);
		}else if(olddz.getState()!=1){
			dz.setState(1);
			date=dzs.updatedianZanState(dz);
		}
		if(date!=0){
			outmap.put("state", "0");			
			outmap.put("message", "留言点赞成功");	
		}else{
			outmap.put("state", "0");			
			outmap.put("message", "留言点赞记录添加失败");						
		}
		return reJson(outmap);
	}
	
	@ResponseBody
	@RequestMapping(value = "/quXiaodianZanLiuYan",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String quXiaodianZanLiuYan(HttpServletRequest request,HttpSession session,HttpServletResponse response,			
			@RequestParam(value="lYId",required = true) int lYId,		
			@RequestParam(value="ip",required = true) String dqIp) {
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
			dz.setlYId(lYId);
			dz.setDZIP(dqIp);
			DianZan dqdz =dzs.selectDianZanState(dz);
			int date=0;			
			if(dqdz!=null&&dqdz.getState()==1){
				//建议赞-1
				lys.quXiaodianZanLiuYan(lYId);
				//修改点赞记录变成不点赞状态
				dz.setState(2);			
				date=dzs.updatedianZanState(dz);
			}else{
				outmap.put("state", "取消点赞失败，无点赞记录或点赞状态为已点赞");
				return reJson(outmap);
			}
			if(date!=0){
				outmap.put("state", "1");	
				outmap.put("message", "取消点赞成功");
			}else{
				outmap.put("state", "0");	
				outmap.put("message", "取消失败，可能该用户未点赞或已取消点赞");			
			}
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
