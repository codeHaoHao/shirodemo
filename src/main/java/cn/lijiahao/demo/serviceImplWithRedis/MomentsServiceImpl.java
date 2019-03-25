package cn.lijiahao.demo.serviceImplWithRedis;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.lijiahao.demo.dao.MomentsDao;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.redis.RedisDaoImpl;
import cn.lijiahao.demo.redis.dao.MomentsRedisDao;
import cn.lijiahao.demo.serviceWithRedis.MomentsService;
import cn.lijiahao.demo.utils.JacksonUtils;
@Service("MomentsService")
public class MomentsServiceImpl implements MomentsService{

	@Autowired
	private MomentsDao momentsDao;
	
	@Autowired
	private MomentsRedisDao momentsRedisDao;
	
	@Autowired
	private RedisDaoImpl redisDao;
	
	public Moments selectByid(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Moments moments = momentsRedisDao.selectByid(id);
		if (moments==null) {
			moments = momentsDao.selectByid(id);
			redisDao.set("moments_", JacksonUtils.bean2Json(moments));
		}
		return moments;
	}

	public Moments selectByMomentsTitleName(String titleName) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Moments> selectAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return momentsDao.selectAllOrderPage(begin, size);
	}



	public int add(Moments moments) throws IOException {
		// TODO Auto-generated method stub
		int mysql = momentsDao.add(moments);
		int redis=momentsRedisDao.add(moments);
		if(mysql>0&&redis>0) return 1;
		return 0;
	}

	public int deleteById(String id) throws IOException {
		// TODO Auto-generated method stub
		momentsRedisDao.deleteById(id);
		int mysqldelete = momentsDao.deleteById(id);
		Moments moments = momentsDao.selectByid(id);
		int redisdelete=momentsRedisDao.add(moments);
		if(mysqldelete>0&&redisdelete>0) return 1;
		return 0;
	}

	public int update(Moments moments) throws IOException {
		// TODO Auto-generated method stub
		int mysql = momentsDao.update(moments);
		Moments moments2 = momentsDao.selectByid(moments.getId());
		int redis=momentsRedisDao.update(moments2);
		if(mysql>0&&redis>0) return 1;
		return 0;
	}

	public List<Moments> selectBysys_uid(String id,int begin,int size) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		List<Moments> momentsList = momentsRedisDao.selectBysys_uid(id);
		
		if(momentsList==null||momentsList.size()==0){
			momentsList = momentsDao.selectBysys_uid(id, begin, size);
			if(momentsList!=null||momentsList.size()!=0){
				for (Moments moments:momentsList) {
					redisDao.lpush("moments_sys_uid_"+id, moments.getId());
				}
			}
		}
		return momentsList;
	}

}
