package com.yc.ssm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.ssm.dao.IUserDao;
import com.yc.ssm.entity.User;

public class TestPageHelper {

	@Test
	public void testPageHelper() {

		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
		//从spring容器中获得Mapper的代理对象
		IUserDao mapper = applicationContext.getBean(IUserDao.class);
		//执行查询，并分页
		User user = new User();
		//分页处理
		PageHelper.startPage(2, 3);
		List<User> list = mapper.obtainUsers(user);
		//取商品列表
		for (User tbItem : list) {
			System.out.println(tbItem.getUserName());
		}
		//取分页信息
		PageInfo<User> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有："+ total + "个用户");
		
	}

}