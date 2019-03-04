package com.pansang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.DianZan;
import com.pansang.mapper.DianZanMapper;

@Service
public class DianZanService {
	
	@Autowired
	private DianZanMapper mapper;
	
	//新增点赞记录
	public int insertDianZan(DianZan dz){
		return mapper.insertDianZan(dz);
	}
	//修改点赞记录
	public int updatedianZanState(DianZan dz){
		return mapper.updatedianZanState(dz);
	}
	//查询点赞状态
	public DianZan selectDianZanState(DianZan dz){
		return mapper.selectDianZanState(dz);
	}
	
		
}
