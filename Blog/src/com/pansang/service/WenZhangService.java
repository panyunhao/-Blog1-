package com.pansang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pansang.entity.WenZhang;
import com.pansang.mapper.WenZhangMapper;

@Service
public class WenZhangService {
	@Autowired
	private WenZhangMapper mapper;
	
	//新增
	public int insertWenZhang(WenZhang wz){
		return mapper.insertWenZhang(wz);
	}
	
	//修改
	public int updateWenZhang(WenZhang wz){
		return mapper.updateWenZhang(wz);
	}
	
	//删除
	public int deleteWenZhang(int wZId){
		return mapper.deleteWenZhang(wZId);
	}
	
	//浏览数+1	
	public int upWenZhangSee(int wZId){
		return mapper.upWenZhangSee(wZId);
	}
	
	//点赞
	public int upWenZhangZan(int wZId){
		return mapper.upWenZhangZan(wZId);
	}
	
	//通过wZId查询单个文章——查看文章详情
	public WenZhang selectWenZhangById(int wZId){
		return mapper.selectWenZhangById(wZId);
	}
	
	//根据文章标题模糊查询文章列表与文章数量(分页)
	public List<WenZhang> selectWenZhangMoHu(Map map){
		return mapper.selectWenZhangMoHu(map);
	}
	public int selectWenZhangNumMoHu(String mohu){
		return mapper.selectWenZhangNumMoHu(mohu);
	}
	
	//查询不同标签下的文章以及数量(分页)
	public List<WenZhang> selectWenZhangListByBiaoQian(Map map){
		return mapper.selectWenZhangListByBiaoQian(map);
	}
	public int selectWenZhangListNumByBiaoQian(String biaoQian){
		return mapper.selectWenZhangListNumByBiaoQian(biaoQian);
	}
	
	//点赞
	public int dianZanWenZhang(int wZId){
		return mapper.dianZanWenZhang(wZId);
	}
	
	//取消点赞
	public int quXiaodianZanWenZhang(int wZId){
		return mapper.quXiaodianZanWenZhang(wZId);
	}
	
}
