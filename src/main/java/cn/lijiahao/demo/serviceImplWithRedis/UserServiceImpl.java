package cn.lijiahao.demo.serviceImplWithRedis;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.lijiahao.demo.dao.UserDao;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.redis.RedisDaoImpl;
import cn.lijiahao.demo.serviceWithRedis.UserService;
import cn.lijiahao.demo.utils.JacksonUtils;
@Service("UserService")
public class UserServiceImpl implements UserService{
	protected final Logger log =LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisDaoImpl redisDao;
	
	@Autowired
	private UserDao userDao;
	
	

	public User selectByid(String id) {
		// TODO Auto-generated method stub
		return userDao.selectByid(id);
	}

	public User selectByUsername(String username) throws JsonParseException, JsonMappingException, IOException  {
		// TODO Auto-generated method stub
		User user = null;
		
		String userjson = redisDao.get("user_"+username);
		log.info("redis:从redis服务器中获取的数据:"+userjson);
		if(StringUtils.isEmpty(userjson)||userjson.equals("null")){
			log.info("===redis缓存服务器中没有相应数据，开始从数据库中获取数据并加入redis缓存服务器");
			user = userDao.selectByUsername(username);
			redisDao.set("user_"+username, JacksonUtils.bean2Json(user));
			log.info("===从数据库向redis缓存服务器加入数据成功");
		}else {
			log.info("===redis缓存服务器获取数据成功");
			user = JacksonUtils.json2Bean(userjson, User.class);
		}
		return user;
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	public List<User> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return userDao.selectAllOrderPag(begin, size);
	}

	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return userDao.selectCountOfRows();
	}

	public int add(User user) throws IOException {
		// TODO Auto-generated method stub
		int success= userDao.add(user);//先在数据库中加入新用户
		/*log.info("mysql:向数据库加入数据成功");
		User user2 = userDao.selectByUsername(user.getUsername());
		String userjson = redisDao.get("user_"+user.getUsername());//判断缓存中是否有新加入的用户
		if(StringUtils.isEmpty(userjson)||userjson.equals("null")){
			//向缓存中加入新注册的用户
			redisDao.set("user_"+user.getUsername(), JacksonUtils.bean2Json(user2));
			log.info("redis:向redis缓存服务器中加入新注册的用户成功");
		}*/
		return success;
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		User user = userDao.selectByid(id);
		String userjson = redisDao.get("user_"+user.getUsername());
		//先判断redis中是否还存在用户登录信息，有的话先删除redis中的用户信息
		if(!StringUtils.isEmpty(userjson)||!userjson.equals("null")){
			redisDao.del("user_"+user.getUsername());
			log.info("reids:redis缓存数据库中用户缓存数据删除成功");
		}
		return userDao.deleteById(id);
	}

	public int update(User user) throws IOException {
		// TODO Auto-generated method stub
		//先更新数据库的user,然后更新redis中的user
		if(userDao.update(user)>0){
			log.info("mysql：数据库更新用户信息成功");
			redisDao.del("user_"+user.getUsername());
			User updatedUser = userDao.selectByid(user.getId());
			redisDao.set("user_", JacksonUtils.bean2Json(updatedUser));
			log.info("reids：缓存更新数据成功");
			return 1;
		}
		return 0;
	}

}
