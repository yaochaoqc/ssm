package com.yc.ssm.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedisHelper {

//	/**
//	 * ip地址
//	 */
//	private static final String HOST = "192.168.23.10";
//	/**
//	 * redisCluster客户端
//	 */
//	private JedisCluster redisCluster;
//	/**
//	 * 客户端连接超时时间
//	 */
//	private final static int TIME_OUT = 3000;
//
//	/**
//	 * soket超时时间
//	 */
//	private final static int SO_TIME_OUT = 3000;
//
//	/**
//	 * 最大尝试次数
//	 */
//	private final static int MAX_ATTEMP = 5;
//
//	@Test
//	public void testJedisCluster() {
//
//		JedisPoolConfig config = new JedisPoolConfig();
//		// 最大连接数
//		config.setMaxTotal(30);
//		// 最大连接空闲数
//		config.setMaxIdle(2);
//
//		// 集群结点
//		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
//		jedisClusterNode.add(new HostAndPort(HOST, 7001));
//		jedisClusterNode.add(new HostAndPort(HOST, 7002));
//		jedisClusterNode.add(new HostAndPort(HOST, 7003));
//		jedisClusterNode.add(new HostAndPort(HOST, 7004));
//		jedisClusterNode.add(new HostAndPort(HOST, 7005));
//		jedisClusterNode.add(new HostAndPort(HOST, 7006));
//		// JedisCluster jc = new JedisCluster(jedisClusterNode, config);
//		//
//		// JedisCluster jcd = new JedisCluster(jedisClusterNode);
//		// jcd.set("name", "zhangsan");
//		// String value = jcd.get("name");
//		// System.out.println(value);
//
//		redisCluster = new JedisCluster(jedisClusterNode, TIME_OUT, SO_TIME_OUT, MAX_ATTEMP, "redis", config);
//		redisCluster.set("name", "zhangsan");
//		String value = redisCluster.get("name");
//		System.out.println(value);
//
//	}

	private ApplicationContext applicationContext;

	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-jedis.xml");
	}

	// redis集群
	@Test
	public void jedisCluster() {
		JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("redisClient");
		
		jedisCluster.set("name", "zhangsan");
		String value = jedisCluster.get("name");
		System.out.println(value);
	}

}
