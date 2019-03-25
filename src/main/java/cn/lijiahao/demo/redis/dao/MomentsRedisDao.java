package cn.lijiahao.demo.redis.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.Moments;
/**
*
*@Description 从redis数据库中获取Moments信息的Dao类接口
*@author 李佳浩
*@Date 2018年11月6日 上午10:33:21
*/
public interface MomentsRedisDao {
	Moments selectByid(String id) throws JsonParseException, JsonMappingException, IOException;
	List<Moments> selectBysys_uid(String id) throws JsonParseException, JsonMappingException, IOException;
	Moments selectByMomentsTitleName(String titleName);
/*	List<Moments> selectAll();*/
	List<Moments> selectAllOrderPag(int begin,int size);
/*	int selectCountOfRows();*/
	int add(Moments moments) throws IOException;
	int deleteById(String id);
	int update(Moments moments) throws IOException;
}
