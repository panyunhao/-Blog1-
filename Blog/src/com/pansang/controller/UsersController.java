package com.pansang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONArray;

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
public class UsersController {
	@Autowired	
	UsersService uss;
	
	@ResponseBody
	@RequestMapping(value = "/usersLoad",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String usersLoad(HttpServletRequest request,HttpSession session,HttpServletResponse response,
							@RequestParam(value="zhangHao",required = true) String zhangHao,
							@RequestParam(value="miMa",required = true) String miMa) {
		Map mapInt=new HashMap();
		mapInt.put("zhangHao", zhangHao);
		mapInt.put("miMa", miMa);	
		Users us=uss.selectUsersByZhangHao(mapInt);		
		Map<String, String> map=new HashMap<String, String>();
		if(us!=null&&us.getUsId()!=0){
			session.setAttribute("dqusers", us);			
			System.out.println("好像也用不着做拦截。");
			System.out.println(us.getUsName()+"登录成功！");
			map.put("status", "1");
			map.put("message", "登录成功");									
		}else{
			System.out.println("账号："+zhangHao+"登录失败");
			map.put("status", "2");
			map.put("message", "账号或密码错误");			
			}
		JSONArray arr=JSONArray.fromObject(map);		
		return arr.toString();
	}
	
	
}
