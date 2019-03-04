package com.pansang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.FuJian;
import com.pansang.mapper.FuJianMapper;

@Service
public class FuJianService {
	
	@Autowired
	private FuJianMapper mapper;
	
	public int insertFuJian(FuJian fj){
		return mapper.insertFuJian(fj);
	}
		
	public int updateFuJian(int fjId){
		return mapper.updateFuJian(fjId);
	}
	
	public int deleteFuJian(int fjId){
		return mapper.deleteFuJian(fjId);
	}
	
	public List<FuJian> selectFuJianByWZId(int wZId){
		return mapper.selectFuJianByWZId(wZId);
	}
	
	public List<FuJian> selectFuJianByUSId(int usId){
		return mapper.selectFuJianByUSId(usId);
	}
	
	public FuJian selectFuJianByFJId(int fJId){
		return mapper.selectFuJianByFJId(fJId);
	}
	
		
}
