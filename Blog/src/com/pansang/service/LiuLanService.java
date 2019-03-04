package com.pansang.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.LiuLan;
import com.pansang.mapper.LiuLanMapper;

@Service
public class LiuLanService {
	
	@Autowired
	private LiuLanMapper mapper;
	
	public int insertLiuLan(LiuLan liulan){		
		return mapper.insertLiuLan(liulan);
	}
		
	public int selectLiuLanByIp(Map map){
		return mapper.selectLiuLanByIp(map);
	}
	
		
}
