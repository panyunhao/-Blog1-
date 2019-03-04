package com.pansang.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pansang.entity.FuJian;;

@Repository
public interface FuJianMapper {
	//上传附件
	public int insertFuJian(FuJian fj);
	//修改下载数
	public int updateFuJian(int fjId);
	//删除附件
	public int deleteFuJian(int fjId);
	//查询某wZId下的所有附件
	public List<FuJian> selectFuJianByWZId(int wZId);
	//查询某用户上传的所有附件
	public List<FuJian> selectFuJianByUSId(int usId);
	//通过fjId获取某个附件
	public FuJian selectFuJianByFJId(int fJId);
	
}
