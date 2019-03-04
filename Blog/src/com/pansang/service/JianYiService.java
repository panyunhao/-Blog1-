package com.pansang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.JianYi;
import com.pansang.mapper.JianYiMapper;

@Service
public class JianYiService {
	
	@Autowired
	private JianYiMapper mapper;
	
	//新增建议
	public int insertJianYi(JianYi jy){
		return mapper.insertJianYi(jy);
	}
	//点赞
	public int dianZanJianYi(int jYId){
		return mapper.dianZanJianYi(jYId);
	}
	//取消点赞
	public int quXiaodianZanJianYi(int jYId){
		return mapper.quXiaodianZanJianYi(jYId);
	}
	//分页查询所有建议
	public List<JianYi> selectJianYiFenYe(Map map){
		return mapper.selectJianYiFenYe(map);
	}
	//查询建议总数
	public int selectJianYiNum(){
		return mapper.selectJianYiNum();
	}
		
}
