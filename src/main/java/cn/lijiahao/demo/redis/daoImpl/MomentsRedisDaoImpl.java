package cn.lijiahao.demo.redis.daoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.lijiahao.demo.dao.MomentsDao;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.redis.RedisDaoImpl;
import cn.lijiahao.demo.redis.dao.MomentsRedisDao;
import cn.lijiahao.demo.utils.JacksonUtils;

@Repository("momentsRedisDao")
public class MomentsRedisDaoImpl implements MomentsRedisDao{

	@Autowired
	private RedisDaoImpl redisDao;
	
	@Autowired 
	private MomentsDao momentsDao;
	
	public Moments selectByid(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Moments moments = null;
		String momentJson = redisDao.get("moments_"+id);
		if(StringUtils.isEmpty(momentJson)||momentJson.equals("null")){
			moments=momentsDao.selectByid(id);
			redisDao.set("moments_"+id, JacksonUtils.bean2Json(moments));
			return moments;
		}else {
			moments = JacksonUtils.json2Bean(momentJson, Moments.class);
		}
		return moments;
	}

	public List<Moments> selectBysys_uid(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		List<String> list = redisDao.lrange("moments_sys_uid_"+id, 0, -1);
		List<Moments> momentsList=new ArrayList<Moments>();
		if(list==null||list.size()==0){
			return null;
		}else {
			for(String momentsId:list){
				String momentsJson =redisDao.get("moments_"+momentsId);
				Moments moments=null;
				if (momentsJson==null||momentsJson.equals("null")) {
					moments = momentsDao.selectByid(momentsId);
					redisDao.set("moments_"+momentsId, JacksonUtils.bean2Json(moments));
				}else {
					moments = JacksonUtils.json2Bean(momentsJson, Moments.class);
				}
				momentsList.add(moments);
			}
			System.out.println("momentsRedisDaoImpl:"+momentsList.size());
			return momentsList;
		}
	}

	public Moments selectByMomentsTitleName(String titleName) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Moments> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return null;
	}


	public int add(Moments moments) throws IOException {
		// TODO Auto-generated method stub
		String momentsJson = JacksonUtils.bean2Json(moments);
		String ok = redisDao.set("moments_"+moments.getId(), momentsJson);
		redisDao.lpush("moments_sys_uid_"+moments.getSys_uid(), moments.getId());
		if(ok.equals("OK")) return 1;
		return 0;
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return (int) redisDao.del("moments_"+id);
	}

	public int update(Moments moments) throws IOException {
		// TODO Auto-generated method stub
		int del = (int) redisDao.del("moments_"+moments.getId());
		String ok = redisDao.set("moments_"+moments.getId(), JacksonUtils.bean2Json(moments));
		if (del==1&&ok.equals("OK"))return 1;
		return 0;
	}
	
}
