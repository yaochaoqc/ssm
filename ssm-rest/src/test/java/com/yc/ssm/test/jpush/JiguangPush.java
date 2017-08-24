package com.yc.ssm.test.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.report.ReceivedsResult;
import com.yc.ssm.util.JPushUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class JiguangPush {

    private static final Logger log = LoggerFactory.getLogger(JiguangPush.class);

    public static void main(String[] args) {
        JPushUtil.isJPush(0,"","","","伟哥 ==> 谢","","","",new HashMap<String, String>());
//        testSendWithSMS();
//        ReportReceived();
    }

    public static void testSendWithSMS() {
        JPushClient jpushClient = new JPushClient("f696fa933270d575146757fd", "b8de2bbf4d47f4030454dfbc");
        try {
            SMS sms = SMS.content("伟哥 ==> 谢", 10);
            PushResult result = jpushClient.sendAndroidMessageWithRegistrationID("伟哥 ==> 谢", "伟哥 ==> 谢", sms, "140fe1da9e9f8330eff");
            log.info("Got result - " + result);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static void ReportReceived(){
        JPushClient jpushClient = new JPushClient("f696fa933270d575146757fd", "b8de2bbf4d47f4030454dfbc");
        try {
            ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
            log.debug("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            log.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            log.error("Should review the error, and fix the request", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
        }
    }
}
