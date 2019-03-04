package com.pansang.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pansang.entity.LiuLan;

@Repository
public interface LiuLanMapper {
	//新增浏览记录
	public int insertLiuLan(LiuLan liulan);	
	//查询浏览记录是否存在
	public int selectLiuLanByIp(Map map);
}
