package com.pansang.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pansang.entity.JianYi;

@Repository
public interface JianYiMapper {
	//新增建议
	public int insertJianYi(JianYi jy);
	//点赞
	public int dianZanJianYi(int jYId);
	//取消点赞
	public int quXiaodianZanJianYi(int jYId);
	//分页查询所有建议
	public List<JianYi> selectJianYiFenYe(Map map);
	//查询建议总数
	public int selectJianYiNum();
	

}
