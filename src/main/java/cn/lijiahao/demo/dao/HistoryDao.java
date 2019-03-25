package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.History;

public interface HistoryDao {
	History selectByid(@Param("id")String id);
	//History selectByHistoryTitleName(@Param("titleName")String titleName);
	History selectHistoryBysys_midAndsys_uid(@Param("sys_mid")String sys_mid,@Param("sys_uid")String sys_uid );
	List<History> selectAll();
	List<String> selectBysys_uid(@Param("sys_uid")String sys_uid);
	List<History> selectAllOrderPag(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows(@Param("sys_uid")String sys_uid);
	int add(History history);
	int deleteById(@Param("id")String id);
	int update(History history);
}
