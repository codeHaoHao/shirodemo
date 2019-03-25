package cn.lijiahao.demo.serviceWithRedis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.Moments;

public interface MomentsService {
	Moments selectByid(String id) throws JsonParseException, JsonMappingException, IOException;
	List<Moments> selectBysys_uid(String id,int begin,int size) throws JsonParseException, JsonMappingException, IOException;
	Moments selectByMomentsTitleName(String titleName);
	/*List<Moments> selectAll();*/
	List<Moments> selectAllOrderPage(int begin,int size);
	/*int selectCountOfRows();*/
	int add(Moments moments) throws IOException;
	int deleteById(String id) throws IOException;
	int update(Moments moments) throws IOException;
}
