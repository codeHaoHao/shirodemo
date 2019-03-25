package cn.lijiahao.demo.serviceWithRedis;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.History;

public interface HistoryService {
	//History selectByid(String id);
	//History selectByHistoryTitleName(@Param("titleName")String titleName);
	List<History> selectAll(String id) throws JsonParseException, JsonMappingException, IOException;
	List<History> selectAllOrderPag(int begin,int size,String id) throws JsonParseException, JsonMappingException, IOException;
	int selectCountOfRows(String id);
	int add(History history) throws IOException;
	//int deleteById(String id);
	//int update(History history);
}
