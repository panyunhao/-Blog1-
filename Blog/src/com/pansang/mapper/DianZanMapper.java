package com.pansang.mapper;

import org.springframework.stereotype.Repository;

import com.pansang.entity.DianZan;

@Repository
public interface DianZanMapper {
	//新增点赞记录
	public int insertDianZan(DianZan dz);	
	//修改点赞记录
	public int updatedianZanState(DianZan dz);
	//查询点赞状态
	public DianZan selectDianZanState(DianZan dz);	

}
