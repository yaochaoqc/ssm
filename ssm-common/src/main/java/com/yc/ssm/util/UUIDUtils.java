package com.yc.ssm.util;

import java.util.UUID;

public class UUIDUtils {
	
	/**
	 * 生成UUID
	 * @return
	 * @author yaochao
	 * @date 2017年1月11日
	 * @version V1.0
	 * modify history
	 */
	public static String obtainUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		str = str.replace("-", "");
		return str;
	}
	
	public static void main(String[] args) {
		String str = obtainUUID();
		System.out.println(str);
	}
}
