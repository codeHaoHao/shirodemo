package cn.lijiahao.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Like;

public interface LikeService {
	Like selectByid(String id);
	//Like selectByLikeTitleName(@Param("titleName")String titleName);
	List<String> selectSys_midBySys_uid(String sys_uid);
	List<Like> selectBySys_uid(String sys_uid);
	List<Like> selectBySys_mid(String sys_mid);
	Like selectBysys_uidAndsys_mid(String sys_uid,String sys_mid);
	List<Like> selectAll();
	List<Like> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(Like like);
	int deleteById(String id);
	int update(Like like);
}
