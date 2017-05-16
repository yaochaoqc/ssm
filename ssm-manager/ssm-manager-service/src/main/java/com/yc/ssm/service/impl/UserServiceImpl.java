package com.yc.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.ssm.dao.IUserDao;
import com.yc.ssm.entity.User;
import com.yc.ssm.service.IUserService;
import com.yc.ssm.util.MD5Utils;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User login(String userName, String password) {
		password = MD5Utils.encodeSHAString(password);
		User user = this.userDao.login(userName, password);
		return user;
	}

	@Override
	public User register(String userName, String password) {
		User user = new User(userName, password);
//		user.setUserName(userName);
//		user.setPassword(password);
//		user.setIsSuper(0);
		Integer i = this.userDao.register(user);
		System.out.println(i);
		return user;
	}

	@Override
	public List<User> obtainUsers(User user) {
		List<User> users = new ArrayList<User>();
		users = this.userDao.obtainUsers(user);
		return users;
	}

	@Override
	public Integer delUserById(String userId) {
		Integer num = this.userDao.delUserById(userId);
		return num;
	}

}
