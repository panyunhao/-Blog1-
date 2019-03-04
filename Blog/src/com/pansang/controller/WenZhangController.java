package com.pansang.controller;

import java.util.ArrayList;
import java.util.Date;
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
public class WenZhangController {
	@Autowired	
	WenZhangService wzls;	
	@Autowired	
	UsersService uss;
	@Autowired	
	LiuLanService lls;
	@Autowired	
	DianZanService dzs;
	@Autowired	
	LiuYanService lys;
	
	//获取某一类的文章列表
	@ResponseBody	
	@RequestMapping(value = "/showWenZhangList",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String showWenZhangList(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="biaoQian",required = true) String biaoQian,
			@RequestParam(value="dqy",required = true) int dqy,
			@RequestParam(value="pageSize",required = true) int pageSize,
			@RequestParam(value="ip",required = false) String dqIp) {
		//记录用户Ip
		saveIp(dqIp,session);
		
		Map mapInt=new HashMap();
		mapInt.put("biaoQian", biaoQian.toUpperCase());
		mapInt.put("begin1", (dqy-1)*pageSize+1);
		mapInt.put("end1", dqy*pageSize);
		//获取文章列表
		List<WenZhang> wzl=wzls.selectWenZhangListByBiaoQian(mapInt);
		//获取文章总数
		int num=wzls.selectWenZhangListNumByBiaoQian(biaoQian.toUpperCase());	
		
		System.out.println("查询成功！当前标签为："+biaoQian+"共"+num+"条,当前第"+dqy+"页("+pageSize+"条/每页)");
		
		Map mapOut =new HashMap();
		mapOut.put("num", num);
		mapOut.put("wzlst", wzl);
		
		return reJson(mapOut);			
	}
	
	//文章模糊分页查询
	@ResponseBody	
	@RequestMapping(value = "/selectWenZhangMoHu",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String selectWenZhangMoHu(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="wZTitle",required = true) String wZTitle,				
			@RequestParam(value="dqy",required = true) int dqy,
			@RequestParam(value="pageSize",required = true) int pageSize,
			@RequestParam(value="ip",required = false) String dqIp) {
		//记录用户Ip
		saveIp(dqIp,session);
		
		Map mapInt=new HashMap();
		mapInt.put("wZTitle", wZTitle);
		mapInt.put("begin1", (dqy-1)*pageSize+1);
		mapInt.put("end1", dqy*pageSize);
		//获取文章列表
		List<WenZhang> wzl=wzls.selectWenZhangMoHu(mapInt);
		//获取该条件下文章总数
		int num=wzls.selectWenZhangNumMoHu(wZTitle);
				
		System.out.println("查询成功！当前模糊查询内容是："+wZTitle+",共"+num+"条,第"+dqy+"页("+pageSize+"条/每页)");
		
		Map mapOut =new HashMap();
		mapOut.put("num", num);
		mapOut.put("wzlst", wzl);								
		return reJson(mapOut);	
	}

	//新增文章
	@ResponseBody
	@RequestMapping(value = "/insertWenZhang",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String insertWenZhang(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			 @RequestParam(value="wZTitle",required = true) String wZTitle,
			 @RequestParam(value="wZText",required = true) String wZText,
			 @RequestParam(value="headImg",required = true) String headImg,
			 @RequestParam(value="WZJJ",required = true) String WZJJ,
			 @RequestParam(value="YC",required = true) int YC,
			 @RequestParam(value="wZurl",required = false) String wZurl,
			 @RequestParam(value="biaoQian",required = true) String biaoQian) {		
		//测试_锁定用户
//		Map mapInt=new HashMap();
//		mapInt.put("zhangHao", "pansang");
//		mapInt.put("miMa", "888888");		
//		Users dqus=uss.selectUsersByZhangHao(mapInt);
		Users dqus=(Users) session.getAttribute("dqusers");	
		if(dqus==null||dqus.getUsId()==0){
			System.out.println("当前用户未登录！默认设置用户为pansang");
			dqus=new Users();
			dqus.setUsId(1);
		}
		WenZhang newWZ= new WenZhang( 0, wZTitle, dqus,headImg, wZText, WZJJ, 1, YC, wZurl, new Date(), 0, 0, biaoQian.toUpperCase(), null, null, 0);		
		//新增记录
		int date=wzls.insertWenZhang(newWZ);
		Map<String, String> map=new HashMap<String, String>();
		if(date!=0){
			map.put("status", "1");
			map.put("message", "新增成功");					
		}else{
			System.out.println("新增返回的date="+date);
			map.put("status", "0");
			map.put("message", "新增失败,请重试");
		}
		JSONArray arr=JSONArray.fromObject(map);		
		return arr.toString();					
	}
	
	//删除文章
	@ResponseBody
	@RequestMapping(value = "/deleteWenZhang",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String deleteWenZhang(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			 @RequestParam(value="wZId",required = true) int wZId) {
		System.out.println("删除的wZId="+wZId);
		//删除记录
		int date=wzls.deleteWenZhang(wZId);
		
		Map<String, String> map=new HashMap<String, String>();
		if(date!=0){
			map.put("status", "1");
			map.put("message", "删除成功");					
		}else{
			System.out.println("删除返回的date="+date);
			map.put("status", "0");
			map.put("message", "删除失败,请重试");
		}				
		JSONArray arr=JSONArray.fromObject(map);
		return arr.toString();					
	}
	
	//通过ID查询某一篇文章
	@ResponseBody
	@RequestMapping(value = "/selectWenZhangById",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")	
	public String selectWenZhangById(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="wZId",required = true,defaultValue = "1") int wZId,
			@RequestParam(value="ip",required = true,defaultValue = "0") String dqIp){
		
		System.out.println("当前Ip="+dqIp);
		//记录用户Ip到浏览器
		saveIp(dqIp,session);
		Map map1=new HashMap();
		map1.put("wZId", wZId);
		map1.put("fKIp", dqIp);
		int date=lls.selectLiuLanByIp(map1);
		if(date==0){
			//浏览量+1
			wzls.upWenZhangSee(wZId); 
			//新增浏览记录
			lls.insertLiuLan(new LiuLan(wZId, dqIp));
		}
		//查询文章内容
		WenZhang wz=wzls.selectWenZhangById(wZId);
		//查询留言
		Map map2=new HashMap();
		map2.put("begin1", 1);
		map2.put("end1", 10);
		map2.put("wZId", wZId);
		//分页查询十条留言
		List<LiuYan> liuyanlist=lys.selectLiuYanFenYe(map2);
		List<LiuYan> newLiuYanList=new ArrayList<LiuYan>();
		//获取留言数
		int num=lys.selectLiuYanNumByWZId(wZId);
		//循环查询二层留言并传入
		for (int i = 0; i < liuyanlist.size(); i++) {
			LiuYan ly=liuyanlist.get(i);
			map2.put("lYId", ly.getlYId());
			ly.setLylist(lys.selectLiuYanMore(map2));
			newLiuYanList.add(ly);
		}
		Map outmap=new HashMap();
		outmap.put("dqwz", wz);
		outmap.put("dqlyl", newLiuYanList);
		outmap.put("num", num);
		return reJson(outmap);
								
	}
	
	//修改文章
	@ResponseBody
	@RequestMapping(value = "/updateWenZhang", produces = "text/html; charset=UTF-8")
	public String updateWenZhang(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="wZId",required = true) int wZId,
			@RequestParam(value="wZTitle",required = false) String wZTitle,
			@RequestParam(value="headImg",required = false) String headImg,
			@RequestParam(value="wZText",required = false) String wZText,
			@RequestParam(value="WZJJ",required = false) String WZJJ,
			@RequestParam(value="wZState",required = false) int wZState,			
			@RequestParam(value="YC",required = false) int YC,
			@RequestParam(value="wZurl",required = false) String wZurl,
			@RequestParam(value="see",required = false) int see,
			@RequestParam(value="biaoQian",required = false) String biaoQian) {
			WenZhang newWZ= new WenZhang();
			newWZ.setwZId(wZId);
			newWZ.setwZTitle(wZTitle);
			newWZ.setHeadImg(headImg);
			newWZ.setwZText(wZText);
			newWZ.setWZJJ(WZJJ);
			newWZ.setwZState(wZState);
			newWZ.setYC(YC);
			newWZ.setwZurl(wZurl);
			newWZ.setSee(see);
			newWZ.setBiaoQian(biaoQian.toUpperCase());
			newWZ.setfBTime(new Date());
			int date=wzls.updateWenZhang(newWZ);			
			Map<String, String> map=new HashMap<String, String>();
			if(date!=0){
				System.out.println("修改行数:"+date);
				map.put("status", "1");
				map.put("message", "修改成功");									
			}else{				
				map.put("status", "0");
				map.put("message", "修改失败");			
				}
			JSONArray arr=JSONArray.fromObject(map);		
			return arr.toString();			
		}
	
	//点赞
	@ResponseBody
	@RequestMapping(value = "/dianZanWenZhang", produces = "text/html; charset=UTF-8")
	public String dianZanWenZhang(HttpServletRequest request,HttpSession session,HttpServletResponse response,
			@RequestParam(value="wZId",required = true,defaultValue = "1") int wZId,
			@RequestParam(value="ip",required = true) String dqIp) {
		System.out.println("当前选中文章ID:"+wZId+"当前IP:"+dqIp);
		Map outmap=new HashMap();
		//点赞数+1
		if(dqIp==null){
			outmap.put("state", "0");
			outmap.put("message", "没IP点个鸡儿");
			System.out.println("没IP点个鸡儿");
			return reJson(outmap);
		}		
		//查询点赞状态
		DianZan dz=new DianZan();
		dz.setwZId(wZId);
		dz.setDZIP(dqIp);
		DianZan olddz =dzs.selectDianZanState(dz);
		int date=0;
		if(olddz==null){
			//文章赞+1
			wzls.dianZanWenZhang(wZId);
			date=dzs.insertDianZan(dz);
		}else if(olddz.getState()!=1){
			//文章赞+1
			wzls.dianZanWenZhang(wZId);
			//新增点赞记录
			dz.setState(1);
			date=dzs.updatedianZanState(dz);
		}
		if(date!=0){
			outmap.put("state", "1");
			outmap.put("message", "点赞记录添加成功");
		}else{
			outmap.put("state", "0");	
			outmap.put("message", "点赞记录添加失败");
		}
		//输出建议列表以及建议数量
		return reJson(outmap);				
	}
	//取消点赞
		@ResponseBody
		@RequestMapping(value = "/quXiaodianZanWenZhang", produces = "text/html; charset=UTF-8")
		public String quXiaodianZanWenZhang(HttpServletRequest request,HttpSession session,HttpServletResponse response,
				@RequestParam(value="wZId",required = true,defaultValue = "1") int wZId,
				@RequestParam(value="ip",required = true) String dqIp) {
			System.out.println("进入文章取消点赞方法,当前选中文章ID:"+wZId);
			Map outmap=new HashMap();
			if(dqIp==null){
				outmap.put("state", "0");
				outmap.put("message", "没IP取消个鸡儿");			
				System.out.println("没IP取消个鸡儿");
				return reJson(outmap);
			}		
			//查询点赞状态
			DianZan dz=new DianZan();
			dz.setwZId(wZId);
			dz.setDZIP(dqIp);
			DianZan olddz =dzs.selectDianZanState(dz);
			int date=0;			
			if(olddz!=null&&olddz.getState()==1){
				//建议赞-1
				wzls.quXiaodianZanWenZhang(wZId);
				//修改点赞记录变成不点赞状态
				dz.setState(2);
				date=dzs.updatedianZanState(dz);
			}			
			if(date!=0){
				outmap.put("state", "1");				
				outmap.put("message", "取消成功");	
			}else{
				outmap.put("state", "0");
				outmap.put("message", "取消失败，可能该用户未点赞或已取消点赞");			
			}
			//输出修改结果
			return reJson(outmap);						
		}
	
	public String reJson(Map map){
		JSONArray arr=JSONArray.fromObject(map);		
		String json1=arr.toString();
		String json2=json1.substring(1, json1.length()-1);
		System.out.println(json2);
		return json2;	
	}
	
	public void saveIp(String ip,HttpSession session){
		String dqIp=(String) session.getAttribute("dqIp");
		System.out.println("旧IP记录为:"+dqIp);
		System.out.println("记录当前用户新IP:"+ip);
		//记录用户Ip
		if(ip!=null&&ip.length()>1){
			session.setAttribute("dqIp", ip);
		}
	}
	
}
