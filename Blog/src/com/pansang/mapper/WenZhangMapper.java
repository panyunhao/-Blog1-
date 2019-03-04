package com.pansang.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pansang.entity.WenZhang;

@Repository
public interface WenZhangMapper {
	
	//新增
	public int insertWenZhang(WenZhang wz);
	//修改
	public int updateWenZhang(WenZhang wz);
	//删除
	public int deleteWenZhang(int wZId);
	//浏览数+1	
	public int upWenZhangSee(int wZId);
	//点赞
	public int upWenZhangZan(int wZId);
	//通过wZId查询单个文章——查看文章详情
	public WenZhang selectWenZhangById(int wZId);
	//根据文章标题模糊查询文章列表与文章数量(分页)
	public List<WenZhang> selectWenZhangMoHu(Map map);
	public int selectWenZhangNumMoHu(String mohu);
	//查询不同标签下的文章以及数量(分页)
	public List<WenZhang> selectWenZhangListByBiaoQian(Map map);
	public int selectWenZhangListNumByBiaoQian(String biaoQian);
	//点赞
	public int dianZanWenZhang(int wZId);
	//取消点赞
	public int quXiaodianZanWenZhang(int wZId);
	
}
