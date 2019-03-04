package com.pansang.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pansang.entity.Users;

@Repository
public interface UsersMapper {
	//新增用户
	public void insertUsers(Users us);
	//修改用户
	public void updateUsers(Users us);
	//删除用户
	public void deleteUsers(Users us);
	//登录验证
	public Users selectUsersByZhangHao(Map map);
}
