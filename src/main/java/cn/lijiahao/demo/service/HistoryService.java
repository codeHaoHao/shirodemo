package cn.lijiahao.demo.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.History;

public interface HistoryService {
	//History selectByid(String id);
	//History selectByHistoryTitleName(@Param("titleName")String titleName);
	List<String> selectBysys_uid(String sys_uid);
	List<History> selectAll(String id);
	History selectHistoryBysys_midAndsys_uid(String sys_mid,String sys_uid );
	List<History> selectAllOrderPag(int begin,int size,String id);
	int selectCountOfRows(String id);
	int add(History history);
	//int deleteById(String id);
	int update(History history);
}
