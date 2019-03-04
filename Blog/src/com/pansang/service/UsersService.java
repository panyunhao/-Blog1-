package com.pansang.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.Users;
import com.pansang.mapper.UsersMapper;

@Service
public class UsersService {
	@Autowired
	private UsersMapper mapper;
	
	//新增用户
	public void insertUsers(Users us){
		mapper.insertUsers(us);
	}
	//修改用户
	public void updateUsers(Users us){
		mapper.updateUsers(us);
	}
	//删除用户
	public void deleteUsers(Users us){
		mapper.deleteUsers(us);
	}
	//登录验证
	public Users selectUsersByZhangHao(Map map){
		return mapper.selectUsersByZhangHao(map);
	}
		
}
