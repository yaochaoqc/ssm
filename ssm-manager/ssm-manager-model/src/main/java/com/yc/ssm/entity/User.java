package com.yc.ssm.entity;

import com.yc.ssm.util.MD5Utils;
import com.yc.ssm.util.UUIDUtils;

public class User {
	
	private String id;//用户编号
	
	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}

	private String userName;//用户名
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	private String password;//密码
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private int isSuper;//是否为管理员(1:是,0:否)

	public int getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(int isSuper) {
		this.isSuper = isSuper;
	}
	
	public User(){
		this.id = UUIDUtils.obtainUUID();
	}
	
	public User(String userName,String password){
		this.id = UUIDUtils.obtainUUID();
		this.userName = userName;
		this.password = MD5Utils.encodeSHAString(password);;
		this.isSuper = 0;
	}
}
