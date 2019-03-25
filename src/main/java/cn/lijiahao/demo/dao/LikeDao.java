package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Like;

public interface LikeDao {
	Like selectByid(@Param("id")String id);
	//Like selectByLikeTitleName(@Param("titleName")String titleName);
	List<String> selectSys_midBySys_uid(@Param("sys_uid")String sys_uid);
	List<Like> selectBySys_uid(@Param("sys_uid")String sys_uid);
	List<Like> selectBySys_mid(@Param("sys_mid")String sys_mid);
	Like selectBysys_uidAndsys_mid(@Param("sys_uid")String sys_uid,@Param("sys_mid")String sys_mid);
	List<Like> selectAll();
	List<Like> selectAllOrderPag(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows();
	int add(Like like);
	int deleteById(@Param("id")String id);
	int update(Like like);
}
