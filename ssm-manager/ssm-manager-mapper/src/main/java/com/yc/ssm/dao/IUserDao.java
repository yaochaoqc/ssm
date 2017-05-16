package com.yc.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;

import com.yc.ssm.entity.User;

public interface IUserDao {

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
//	@Select("select * from user where userName = #{0} AND password = #{1}")
//	User login(String userName, String password);
	
//	@Select("select * from user where userName = #{userName} AND password = #{password}")
//	User login(@Param("userName")String userName, @Param("password")String password);
	
    User login(@Param("userName")String userName, @Param("password")String password);
    
    Integer register(User user);
    
    List<User> obtainUsers(User user);
    
    Integer delUserById(@Param("id")String id);
    
//    List<User> selUsers();
    
}