package cn.lijiahao.demo.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.Md5Hash;


import cn.lijiahao.demo.po.User;

import cn.lijiahao.demo.utils.SnowFlake;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
	
	
	/**
	 * @Description 用SnowFlake生成id
	 * @author 李佳浩
	 * @Date 2018年10月15日 上午9:52:02
	 */
	@org.junit.Test
	public void testSnowFlake(){
		System.out.println(SnowFlake.snowflake.nextId());
		
		
	}
	
	/**
	 * @Description 用Md5Hash来运算密码
	 * @author 李佳浩
	 * @Date 2018年10月15日 上午9:46:54
	 */
	@org.junit.Test
	public void testMD5(){
		String salt = "iaeiwfsjkfhewui";
		Md5Hash md5 = new Md5Hash("admin", salt, 1);
		System.out.println(md5.toString());
		
	}
	
	/**
	*
	*@Description 测试redis连接是否正常
	*@param 
	*@author 李佳浩
	*@Date 2018年10月23日 上午10:56:28
	*/
	@org.junit.Test
	public void testRedis(){
		// 创建一个Redis连接池，并对它进行设置
				JedisPoolConfig poolConfig = new JedisPoolConfig();
				poolConfig.setMaxTotal(50);// 最大连接数，连接全部用完，进行等待
				poolConfig.setMinIdle(10); // 最小空余数
				poolConfig.setMaxIdle(30); // 最大空余数
				JedisPool pool = new JedisPool(poolConfig, "192.168.112.144", 6379);
				// 从jedis中获取连接资源，并进行权限认证
				Jedis jedis = pool.getResource();
				jedis.auth("123456");
		User user = new User("456484134848", "88888888", "88888888", "王啸宇", null, 20, "男", "iaeiwfsjkfhewui", "0");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", user.getId());
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		map.put("name", user.getName());
		map.put("dataOfBirth", user.getDataOfBirth()+"");
		map.put("age", user.getAge()+"");
		map.put("gender", user.getGender());
		map.put("salt", user.getSalt());
		map.put("locked", user.getLocked());
		jedis.hmset("user_"+user.getId(),map );
		String fields = "id,username,password,name,dataOfBirth,age,gender,salt,locked";
		List<String>list=jedis.hmget("user_456484134848","id","username","password","name","dataOfBirth","age","gender","salt","locked");
		
	}
	@org.junit.Test
	public void testRedis2(){
		Timestamp timestamp = new Timestamp(new Date().getTime());
		System.out.println(timestamp.toString());
	}
	@org.junit.Test
	public void testRedis3(){
		// 创建一个Redis连接池，并对它进行设置
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(50);// 最大连接数，连接全部用完，进行等待
		poolConfig.setMinIdle(10); // 最小空余数
		poolConfig.setMaxIdle(30); // 最大空余数
		JedisPool pool = new JedisPool(poolConfig, "192.168.112.144", 6379);
		// 从jedis中获取连接资源，并进行权限认证
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		
		String ok = jedis.set("147258", "147258");
		System.out.println(ok);
	}
	@org.junit.Test
	public void testTime(){
		Date time = new Date();
		Timestamp timestamp = new Timestamp(time.getTime());
	}
	@org.junit.Test
	public void testIp() throws UnknownHostException{
		String address = InetAddress.getLocalHost().getHostAddress().toString();
		System.out.println(address);
		// 创建本地主机IP地址对象
		        try {
		           InetAddress addr = InetAddress.getLocalHost();
		           String hostAddr = addr.getHostAddress();        // 获取IP地址
		            String hostName = addr.getHostName();           // 获取本地机器名
		            System.out.println("本地IP地址：" + hostAddr);
		           System.out.println("本地的机器名称：" + hostName);
		       } catch (UnknownHostException e) {
		            e.printStackTrace();
		        }
	}
}
