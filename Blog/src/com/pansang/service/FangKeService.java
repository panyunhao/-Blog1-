package com.pansang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.FangKe;
import com.pansang.mapper.FangKeMapper;

@Service
public class FangKeService {
	
	@Autowired
	private FangKeMapper mapper;
	
	public int insertFangKe(FangKe fk){
		return mapper.insertFangKe(fk);
	}
		
	public int updateFangKe(FangKe fk){
		return mapper.updateFangKe(fk);
	}
		
	public FangKe selectFangKeByIP(String FKIP){
		return mapper.selectFangKeByIP(FKIP);
	}
		
}
