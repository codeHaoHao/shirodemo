package cn.lijiahao.demo.serviceImplWithRedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.HistoryDao;
import cn.lijiahao.demo.po.History;
import cn.lijiahao.demo.redis.RedisDaoImpl;
import cn.lijiahao.demo.serviceWithRedis.HistoryService;
import cn.lijiahao.demo.utils.JacksonUtils;
@Service("HistoryService")
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryDao historyDao;
	
	@Autowired
	private RedisDaoImpl redisDao;

	public List<History> selectAll(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		List<History> historyList = new ArrayList<History>();
		List<String> list=redisDao.lrange("userHistory_"+id, 0, -1);
		for(String userHistory:list){
			historyList.add(JacksonUtils.json2Bean(userHistory, History.class));
		}
		if(historyList.size()==0)return null;
		return historyList;
		
	}

	public List<History> selectAllOrderPag(int begin, int size,String id) throws JsonParseException, JsonMappingException, IOException {
		List<History> historyList = new ArrayList<History>();
		List<String> list=redisDao.lrange("userHistory_"+id, begin, begin+size);
		for(String userHistory:list){
			historyList.add(JacksonUtils.json2Bean(userHistory, History.class));
		}
		if(historyList.size()==0)return null;
		return historyList;
	}

	public int selectCountOfRows(String id) {
		
		return (int) redisDao.llen("userHistory_"+id);
	}

	public int add(History history) throws IOException {
		// TODO Auto-generated method stub
		long temp=redisDao.lpush("userHistory_"+history.getSys_uid(),JacksonUtils.bean2Json(history));
		return (int) temp;
	}

	

}
