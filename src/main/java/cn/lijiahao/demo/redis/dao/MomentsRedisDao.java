package cn.lijiahao.demo.redis.dao;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.Moments;

/**
 *
 *@Description 从redis数据库中获取Moments信息的Dao类接口
 *@author franky
 */
public interface MomentsRedisDao {
  Moments selectByid(String id)
      throws JsonParseException, JsonMappingException, IOException;

  List<Moments> selectBysys_uid(String id)
      throws JsonParseException, JsonMappingException, IOException;

  Moments selectByMomentsTitleName(String titleName);

  List<Moments> selectAllOrderPag(int begin, int size);

  int add(Moments moments) throws IOException;

  int deleteById(String id);

  int update(Moments moments) throws IOException;
}
