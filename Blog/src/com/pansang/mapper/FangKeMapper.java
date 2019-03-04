package com.pansang.mapper;

import org.springframework.stereotype.Repository;

import com.pansang.entity.FangKe;

@Repository
public interface FangKeMapper {
	//新增访客
	public int insertFangKe(FangKe fk);
	//修改访客
	public int updateFangKe(FangKe fk);
	//查询访客
	public FangKe selectFangKeByIP(String FKIP);
	
	
}
