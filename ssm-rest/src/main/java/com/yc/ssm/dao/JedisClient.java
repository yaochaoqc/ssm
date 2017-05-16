package com.yc.ssm.dao;

public interface JedisClient {

	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	String get(String key);
	
	/**
	 * 设置值
	 * @param key
	 * @param value
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	String set(String key, String value);
	
	/**
	 * 获取哈希值
	 * @param hkey
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	String hget(String hkey, String key);
	
	/**
	 * 设置哈希值
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long hset(String hkey, String key, String value);
	
	/**
	 * 自增
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long incr(String key);
	
	/**
	 * 设置缓存有效期
	 * @param key
	 * @param second
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long expire(String key, int second);
	
	/**
	 * 获取缓存有效期
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long ttl(String key);
	
	/**
	 * 根据key删除值
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long del(String key);
	
	/**
	 * 根据key删除哈希值
	 * @param hkey
	 * @param key
	 * @return
	 * @author yaochao
	 * @date 2017年4月5日
	 * @version V1.0
	 * modify history
	 */
	long hdel(String hkey, String key);
	
}
