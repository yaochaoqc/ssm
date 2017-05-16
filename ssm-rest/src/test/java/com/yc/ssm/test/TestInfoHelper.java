package com.yc.ssm.test;

import java.util.HashMap;
import java.util.Set;
//import com.hospital.sdk.CCPRestSDK;
//import com.hospital.sdk.CCPRestSDK.BodyType;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class TestInfoHelper {

	public static void main(String args[]) {
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		// 初始化服务器端口和地址
		restAPI.init("app.cloopen.com", "8883"); // 这里是固定内容
		// 初始化主账户名称和账户令牌,账户ID和令牌都可以在登录网站后,在控制台首页看到
		restAPI.setAccount("8aaf07085b2236cf015b2264cb14007b", "e00ab34cba1642a9b663f94eac28df7e");
		// 初始化应用ID,在应用列表里面可以看到
		restAPI.setAppId("8aaf07085b2236cf015b2264ccd50081");
		// 参数为: 1:手机号(多个手机号用逗号隔开) 2:短信模版ID(免费测试模版是1)
		// 3:模版内容,多个内容用逗号隔开(这里第二个参数是好多分钟内输入...)
		result = restAPI.sendTemplateSMS("15928104077", "1", new String[] { "这里是测试内容,验证码123321", "2" });
		System.out.println("SDKTestSendTemplateSMS result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			// 正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				System.out.println(key + " = " + object);
			}
		} else {
			// 异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}
	}
}
