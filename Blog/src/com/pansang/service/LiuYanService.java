package com.pansang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.LiuYan;
import com.pansang.mapper.LiuYanMapper;

@Service
public class LiuYanService {
	
	@Autowired
	private LiuYanMapper mapper;
	
	//新增建议
	public int insertLiuYan(LiuYan ly){
		return mapper.insertLiuYan(ly);
	}
	//点赞
	public int dianZanLiuYan(int lYId){
		return mapper.dianZanLiuYan(lYId);
	}
	//取消点赞
	public int quXiaodianZanLiuYan(int lYId){
		return mapper.quXiaodianZanLiuYan(lYId);
	}
	//分页查询所有建议
	public List<LiuYan> selectLiuYanFenYe(Map map){
		return mapper.selectLiuYanFenYe(map);
	}
	//查询文章下的留言数量
	public int selectLiuYanNumByWZId(int wZId){
		return mapper.selectLiuYanNumByWZId(wZId);
	}
	//查询二层留言
	public List<LiuYan> selectLiuYanMore(Map map){
		return mapper.selectLiuYanMore(map);
	}
		
}
