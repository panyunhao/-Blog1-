package com.pansang.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pansang.entity.LiuYan;

@Repository
public interface LiuYanMapper {
	//新增留言
	public int insertLiuYan(LiuYan ly);
	//点赞
	public int dianZanLiuYan(int lYId);
	//取消点赞
	public int quXiaodianZanLiuYan(int lYId);
	//分页查询留言
	public List<LiuYan> selectLiuYanFenYe(Map map);
	//查询留言数量
	public int selectLiuYanNumByWZId(int wZId);
	//查询二层留言
	public List<LiuYan> selectLiuYanMore(Map map);
	
	
}
