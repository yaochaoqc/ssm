package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.User;

public interface IUserService {
	
	/**
	 * 登陆
	 * @param userName
	 * @param password
	 * @return
	 * @author yaochao
	 * @date 2017年1月11日
	 * @version V1.0
	 * modify history
	 */
	public User login(String userName,String password);
	
	/**
	 * 获取所有用户
	 * @return
	 * @author yaochao
	 * @date 2017年2月8日
	 * @version V1.0
	 * modify history
	 */
	public List<User> obtainUsers(User user);
	
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @return
	 * @author yaochao
	 * @date 2017年1月11日
	 * @version V1.0
	 * modify history
	 */
	public User register(String userName,String password);
	
	/**
	 * 根据id删除
	 * @param userId
	 * @return
	 * @author yaochao
	 * @date 2017年2月9日
	 * @version V1.0
	 * modify history
	 */
	public Integer delUserById(String userId);
	
}
