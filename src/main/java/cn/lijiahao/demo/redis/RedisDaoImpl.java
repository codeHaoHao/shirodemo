package cn.lijiahao.demo.redis;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

@Repository("redisDao")
public class RedisDaoImpl{
 
	@Autowired
	private ShardedJedisPool shardedJedisPool;
	
	
//*******************************************Keys*******************************************//
	/**
	 * 设置key的过期时间，以秒为单位
	 * @param String key
	 * @param 时间,已秒为单位
	 * @return 影响的记录数
	 * */
	public long expired(String key,int seconds){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.expire(key, seconds);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
	 * @param String key
	 * @param 时间,已秒为单位
	 * @return 影响的记录数
	 * */
	public long expireAt(String key,long timestamp){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.expireAt(key, timestamp);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 查询key的过期时间
	 * @param String key
	 * @return 以秒为单位的时间表示
	 * */
	public long ttl(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.ttl(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 取消对key过期时间的设置
	 * @param key
	 * @return 影响的记录数
	 * */
	public long persist(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.persist(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 删除keys对应的记录
	 * @param String key
	 * @return 删除的记录数
	 * */
	public long del(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.del(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 判断key是否存在
	 * @param String key
	 * @return boolean
	 * */
	public boolean exists(String key){
		ShardedJedis shardedJedis = null;
		boolean value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.exists(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 对List,Set,SortSet进行排序,如果集合数据较大应避免使用这个方法
	 * @param String key
	 * @return List<String> 集合的全部记录
	 * **/
	public List<String> sort(String key){
		ShardedJedis shardedJedis = null;
		List<String> value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.sort(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 对List,Set,SortSet进行排序或limit
	 * @param String key
	 * @param SortingParams parame 定义排序类型或limit的起止位置.
	 * @return List<String> 全部或部分记录
	 * **/
	public List<String> sort(String key,SortingParams parame){
		ShardedJedis shardedJedis = null;
		List<String> value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.sort(key, parame);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 返回指定key存储的类型
	 * @param String key
	 * @return String string|list|set|zset|hash
	 * **/
	public String type(String key){
		ShardedJedis shardedJedis = null;
		String value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.type(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	
//*******************************************Sets*******************************************//
	/**
	 * 向Set添加一条记录，如果member已存在返回0,否则返回1
	 * @param String  key
	 * @param String member
	 * @return 操作码,0或1
	 * */
	public long sadd(String key,String member){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.sadd(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取给定key中元素个数
	 * @param String key
	 * @return 元素个数
	 * */
	public long scard(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.scard(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 确定一个给定的值是否存在
	 * @param String  key
	 * @param String member 要判断的值
	 * @return 存在返回1，不存在返回0
	 * **/
	public boolean sismember(String key,String member){
		ShardedJedis shardedJedis = null;
		boolean value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.sismember(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 返回集合中的所有成员
	 * @param String  key
	 * @return 成员集合
	 * */
	public Set<String> smember(String key){
		ShardedJedis shardedJedis = null;
		Set<String> value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.smembers(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 从集合中删除成员
	 * @param String  key
	 * @return 被删除的成员
	 * */
	public String spop(String key){
		ShardedJedis shardedJedis = null;
		String value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.spop(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 从集合中删除指定成员
	 * @param String key
	 * @param String  member 要删除的成员
	 * @return 状态码，成功返回1，成员不存在返回0
	 * */
	public long srem(String key,String member){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.srem(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	
//*******************************************SortSet*******************************************//
	/**
	 * 向集合中增加一条记录,如果这个值已存在，这个值对应的权重将被置为新的权重
	 * @param String  key
	 * @param double score 权重
	 * @param String  member 要加入的值，
	 * @return 状态码 1成功，0已存在member的值
	 * */
	public long zadd(String key,double score,String member){
		
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zadd(key, score,member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取集合中元素的数量
	 * @param String  key
	 * @return 如果返回0则集合不存在
	 * */
	public long zcard(String key){
		
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zcard(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取指定权重区间内集合的数量
	 * @param String key
	 * @param double min 最小排序位置
	 * @param double max 最大排序位置
	 * */
	public long zcount(String key,double min,double max){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zcount(key, min, max);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获得set的长度
	 * 
	 * @param key
	 * @return
	 */
	public long zlength(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrange(key, 0, -1).size();
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 权重增加给定值，如果给定的member已存在
	 * @param String  key
	 * @param double score 要增的权重
	 * @param String  member 要插入的值
	 * @return 增后的权重
	 * */
	public double zincrby(String key,double score,String member){
		ShardedJedis shardedJedis = null;
		double value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zincrby(key, score, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 返回指定位置的集合元素,0为第一个元素，-1为最后一个元素
	 * @param String key
	 * @param int start 开始位置(包含)
	 * @param int end 结束位置(包含)
	 * @return Set<String>
	 * */
	public Set<String> zrange(String key,int start,int end){
		ShardedJedis shardedJedis = null;
		Set<String> value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrange(key, start, end);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 返回指定权重区间的元素集合
	 * @param String key
	 * @param double min 上限权重
	 * @param double max 下限权重
	 * @return Set<String>
	 * */
	public Set<String> zrangeByScore(String key,double min,double max){
		ShardedJedis shardedJedis = null;
		Set<String> value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrangeByScore(key, min, max);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取指定值在集合中的位置，集合排序从低到高
	 * @see zrevrank
	 * @param String key
	 * @param String member
	 * @return long 位置
	 * */
	public long zrank(String key,String member){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrank(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取指定值在集合中的位置，集合排序从高到低
	 * @see zrank
	 * @param String key
	 * @param String member
	 * @return long 位置
	 * */
	public long zrevrank(String key,String member){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrevrank(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 从集合中删除成员
	 * @param String key
	 * @param String member 
	 * @return 返回1成功
	 * */
	public long zrem(String key,String member){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrem(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 删除
	 * @param key
	 * @return
	 */
	public long zrem(String key){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrem(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 删除给定位置区间的元素
	 * @param String  key
	 * @param int start 开始区间，从0开始(包含)
	 * @param int end 结束区间,-1为最后一个元素(包含)
	 * @return 删除的数量
	 * */
	public long zremrangeByRank(String key,int start,int end){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zremrangeByRank(key, start, end);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 删除给定权重区间的元素
	 * @param String key
	 * @param double min 下限权重(包含)
	 * @param double max 上限权重(包含)
	 * @return 删除的数量
	 * */
	public long zremrangeByScore(String key,double start,double end){
		ShardedJedis shardedJedis = null;
		long value=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zremrangeByScore(key, start, end);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 获取给定区间的元素，原始按照权重由高到低排序
	 * @param String  key
	 * @param int start
	 * @param int end
	 * @return Set<String>
	 * */
	public Set<String> zrevrange(String key,int start,int end){
		ShardedJedis shardedJedis = null;
		Set<String> value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zrevrange(key, start, end);
		}finally{
			shardedJedis.close();
		}
		return value;
		
	}
	/**
	 * 获取给定值在集合中的权重
	 * @param String  key
	 * @param memeber
	 * @return double 权重
	 * */
	public double zscore(String key,String member){
		ShardedJedis shardedJedis = null;
		double value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.zscore(key, member);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
//*******************************************Hash*******************************************//
	/**
	 * 从hash中删除指定的存储
	 * @param String key
	 * @param String  fieid 存储的名字
	 * @return 状态码，1成功，0失败
	 * */
	public long hdel(String key,String...fields){
		ShardedJedis shardedJedis = null;
		long value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.hdel(key, fields);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	
	public long hdel(String key){
		ShardedJedis shardedJedis = null;
		long value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.hdel(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 测试hash中指定的存储是否存在
	 * @param String key
	 * @param String  fieid 存储的名字
	 * @return 1存在，0不存在
	 * */
	public boolean hexists(String key,String field){
		ShardedJedis shardedJedis = null;
		boolean value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.hexists(key, field);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 返回hash中指定存储位置的值
	 * 
	 * @param String key
	 * @param String fieid 存储的名字
	 * @return 存储对应的值
	 * */
	public String hget(String key,String field){
		ShardedJedis shardedJedis = null;
		String value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.hget(key, field);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 以Map的形式返回hash中的存储和值
	 * @param String    key
	 * @return Map<Strinig,String>
	 * */
	public Map<String, String> hgetAll(String key){
		ShardedJedis shardedJedis = null;
		Map<String, String> value;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.hgetAll(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 添加一个对应关系
	 * @param String  key
	 * @param String fieid
	 * @param String value
	 * @return 状态码 1成功，0失败，fieid已存在将更新，也返回0
	 * **/
	public long hset(String key, String field, String value) {
		ShardedJedis shardedJedis = null;
		long value1=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hset(key, field, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 添加对应关系，只有在fieid不存在时才执行
	 * @param String key
	 * @param String fieid
	 * @param String value
	 * @return 状态码 1成功，0失败fieid已存
	 * **/
	public long hsetnx(String key,String field,String value){
		ShardedJedis shardedJedis = null;
		long value1=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hsetnx(key, field, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 获取hash中value的集合
	 * 
	 * @param String
	 *            key
	 * @return List<String>
	 * */
	public List<String> hvals(String key){
		ShardedJedis shardedJedis = null;
		List<String> value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hvals(key);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
	 * @param String  key
	 * @param String  fieid 存储位置
	 * @param String long value 要增加的值,可以是负数
	 * @return 增加指定数字后，存储位置的值
	 * */
	public long hincrby(String key,String field,long value){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hincrBy(key, field, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 返回指定hash中的所有存储名字,类似Map中的keySet方法
	 * @param String key
	 * @return Set<String> 存储名称的集合
	 * */
	public Set<String> hkeys(String key){
		ShardedJedis shardedJedis = null;
		Set<String> value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hkeys(key);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 获取hash中存储的个数，类似Map中size方法
	 * @param String  key
	 * @return long 存储的个数
	 * */
	public long hlen(String key){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hlen(key);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
	 * @param String  key
	 * @param String ... fieids 存储位置
	 * @return List<String>
	 * */
	public List<String> hmget(String key,String...fields){
		ShardedJedis shardedJedis = null;
		List<String> value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hmget(key, fields);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 添加对应关系，如果对应关系已存在，则覆盖
	 * @param Strin   key
	 * @param Map <String,String> 对应关系
	 * @return 状态，成功返回OK
	 * */
	public String hmset(String key,Map<String, String> hash){
		ShardedJedis shardedJedis = null;
		String value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.hmset(key, hash);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
//*******************************************Strings*******************************************//
	/**
	 * 根据key获取记录
	 * @param String  key
	 * @return 值
	 * */
	public String get(String key) {
		ShardedJedis shardedJedis = null;
		String value=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value=shardedJedis.get(key);
		}finally{
			shardedJedis.close();
		}
		return value;
	}
	/**
	 * 添加有过期时间的记录
	 * 
	 * @param String  key
	 * @param int seconds 过期时间，以秒为单位
	 * @param String value
	 * @return String 操作状态
	 * */
	public String setEx(String key,int seconds,String value){
		ShardedJedis shardedJedis = null;
		String value1=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.setex(key, seconds, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	/**
	 * 添加一条记录，仅当给定的key不存在时才插入
	 * @param String key
	 * @param String value
	 * @return long 状态码，1插入成功且key不存在，0未插入，key存在
	 * */
	public long setnx(String key,String value){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.setnx(key, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	
	/**
	 * 添加记录,如果记录已存在将覆盖原有的value
	 * @param String key
	 * @param String value
	 * @return 状态码
	 * */
	public String set(String key, String value) {
		ShardedJedis shardedJedis = null;
		String value1=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.set(key, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 从指定位置开始插入数据，插入的数据会覆盖指定位置以后的数据<br/>
	 * 例:String str1="123456789";<br/>
	 * 对str1操作后setRange(key,4,0000)，str1="123400009";
	 * @param String  key
	 * @param long offset
	 * @param String  value
	 * @return long value的长度
	 * */
	public long setRange(String key,long offset,String value){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.setrange(key, offset, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
		
	}
	/**
	 * 在指定的key中追加value
	 * @param String  key
	 * @param String value
	 * @return long 追加后value的长度
	 * **/
	public long append(String key,String value){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.append(key, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
	 * @param String key
	 * @param long number 要减去的值
	 * @return long 减指定值后的值
	 * */
	public long decrBy(String key,long number){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.decrBy(key, number);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	/**
	 * <b>可以作为获取唯一id的方法</b><br/>
	 * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
	 * @param String  key
	 * @param long number 要减去的值
	 * @return long 相加后的值
	 * */
	public long incrBy(String key,long number){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.incrBy(key, number);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	/**
	 * 对指定key对应的value进行截取 
	 * @param String   key
	 * @param long startOffset 开始位置(包含)
	 * @param long endOffset 结束位置(包含)
	 * @return String 截取的值
	 * */
	public String getrange(String key,long startOffset,long endOffset){
		ShardedJedis shardedJedis = null;
		String value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.getrange(key, startOffset, endOffset);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	/**
	 * 获取并设置指定key对应的value<br/>
	 * 如果key存在返回之前的value,否则返回null
	 * @param String  key
	 * @param String value
	 * @return String 原始value或null
	 * */
	public String getSet(String key,String value){
		ShardedJedis shardedJedis = null;
		String value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.getSet(key, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	/**
	 * 获取key对应的值的长度
	 * @param String key
	 * @return value值得长度
	 * */
	public long strlen(String key){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.strlen(key);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
	
	
//*******************************************Lists*******************************************//
	/**
	 * List长度
	 * @param String key
	 * @return 长度
	 * */
	public long llen(String key){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.llen(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * List长度
	 * @param byte[] key
	 * @return 长度
	 * */
	public long llen(byte[] key){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.llen(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 覆盖操作,将覆盖List中指定位置的值
	 * @param byte[] key
	 * @param int index 位置
	 * @param byte[] value 值
	 * @return 状态码
	 * */
	public String lset(byte[] key,int index,byte[] value){
		ShardedJedis shardedJedis = null;
		String returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lset(key, index, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 覆盖操作,将覆盖List中指定位置的值
	 * @param key
	 * @param int index 位置
	 * @param String  value 值
	 * @return 状态码
	 * */
	public String lset(String key,int index,String value){
		ShardedJedis shardedJedis = null;
		String returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lset(key, index, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 在value的相对位置插入记录
	 * @param key
	 * @param LIST_POSITION   前面插入或后面插入
	 * @param String pivot 相对位置的内容
	 * @param String value 插入的内容
	 * @return 记录总数
	 * */
	public long linsert(String key,LIST_POSITION where,String pivot,String value){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.linsert(key, where, pivot, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
		
	}
	/**
	 * 在指定位置插入记录
	 * @param String key
	 * @param LIST_POSITION 前面插入或后面插入
	 * @param byte[] pivot 相对位置的内容
	 * @param byte[] value 插入的内容
	 * @return 记录总数
	 * */
	public long linsert(byte[] key,LIST_POSITION where,byte[] pivot,byte[] value){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.linsert(key, where, pivot, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
		
	}
	/**
	 * 获取List中指定位置的值
	 * @param String  key
	 * @param int index 位置 
	 * @return 值
	 * **/
	public String lindex(String key,int index){
		ShardedJedis shardedJedis = null;
		String returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lindex(key, index);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 获取List中指定位置的值 
	 * @param byte[] key
	 * @param int index 位置
	 * @return 值
	 * **/
	public byte[] lindex(byte[] key,int index){
		ShardedJedis shardedJedis = null;
		byte[] returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lindex(key, index);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 将List中的第一条记录移出List
	 * @param String key
	 * @return 移出的记录 
	 * */
	public String lpop(String key){
		ShardedJedis shardedJedis = null;
		String returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lpop(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 将List中的第一条记录移出List
	 * @param byte[] key
	 * @return 移出的记录
	 * */
	public byte[] lpop(byte[] key){
		ShardedJedis shardedJedis = null;
		byte[] returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lpop(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 将List中最后第一条记录移出List
	 * 
	 * @param byte[] key
	 * @return 移出的记录
	 * */
	public String rpop(String key){
		ShardedJedis shardedJedis = null;
		String returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.rpop(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 将List中最后第一条记录移出List
	 * 
	 * @param byte[] key
	 * @return 移出的记录
	 * */
	public byte[] rpop(byte[] key){
		ShardedJedis shardedJedis = null;
		byte[] returnvalun=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.rpop(key);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 向List左侧头部追加记录
	 * @param String key
	 * @param String value
	 * @return 记录总数
	 * */
	public long lpush(String key,String value){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.lpush(key, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 向List头部追加记录
	 * @param String  key
	 * @param String  value
	 * @return 记录总数
	 * */
	public long rpush(String key,String value){
		ShardedJedis shardedJedis = null;
		long returnvalun=0;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalun=shardedJedis.rpush(key, value);
		}finally{
			shardedJedis.close();
		}
		return returnvalun;
	}
	/**
	 * 获取指定范围的记录，可以做为分页使用
	 * @param String key
	 * @param long start
	 * @param long end
	 * @return List
	 * */
	public List<String> lrange(String key,long start,long end){
		ShardedJedis shardedJedis = null;
		List<String> returnvalue=null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			returnvalue=shardedJedis.lrange(key, start, end);
		}finally{
			shardedJedis.close();
		}
		return returnvalue;
	}
	/**
	 * 删除指定的key的指定value，0表示删除全部，负数从list后面往前删除
	 * @param String  key
	 * @param String value
	 * @return String 原始value或null
	 * */
	public long lrem(String key,int count,String value){
		ShardedJedis shardedJedis = null;
		long value1;
		try {
			shardedJedis = shardedJedisPool.getResource();
			value1=shardedJedis.lrem(key, count, value);
		}finally{
			shardedJedis.close();
		}
		return value1;
	}
}