package com.yc.ssm.util;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JPushUtil {

    private static final Logger log = LoggerFactory.getLogger(JPushUtil.class);
//    private static String masterSecret = "f696fa933270d575146757fd";
//    private static String appKey = "b8de2bbf4d47f4030454dfbc";
    private static String masterSecret = "";
    private static String appKey = "";
    private static final String ALERT = "推送信息";

    static {
        InputStream in = JPushUtil.class.getClassLoader().getResourceAsStream("JPush.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            masterSecret = prop.getProperty("masterSecret").trim();
            appKey = prop.getProperty("appKey").trim();
            System.out.println("masterSecret:" + masterSecret);
            System.out.println("appKey:" + appKey);
        } catch (IOException e) {
            System.out.println("读取配置文件出错");
            e.printStackTrace();
        }
    }
    /**
     * 极光推送
     */
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        for (Map.Entry<String,String> entry:map.entrySet()) {

        }
        String alias = "123456";//声明别名
        log.info("对别名" + alias + "的用户推送信息");
//        PushResult result = push(0,"","","",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx",map);
//        PushResult result = push(0,"tag","","",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx");
//        PushResult result = push(0,"",String.valueOf(alias),"",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx");
//        PushResult result = push(0,"","","140fe1da9e9f8330eff",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx");
//        PushResult result = push(1,"tag","","",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx");
//        PushResult result = push(1,"",String.valueOf(alias),"",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111","xxxx","xxxxxx");
        PushResult result = push(0,"","","1a0018970a93a08f0dc",ALERT,"xxx" ,"一个小少年，天天飞天边。","11111",map);
        if(result != null && result.isResultOK()){
            log.info("针对别名" + alias + "的信息推送成功！");
        }else{
            log.info("针对别名" + alias + "的信息推送失败！");
        }
    }

    /**
     * 极光推送方法(采用java SDK)
     * 如果 别名不为空 则根据别名推送 别名为空 设备编号不为空 按设备编号推送 两者均为空 默认推送所有用户
     * @param infoType 0.通知推送 1.自定义推送
     * @param alias 别名
     * @param registrationId 设备编号
     * @param alert 通知推送内容
     * @param title 自定义推送标题
     * @param contentMsg 自定义推送内容
     * @param contentType 自定义推送类型
     * @param map 自定义推送附加属性
     * @return bool true 消息推送成功 false 消息推送失败
     */
    public static boolean isJPush(int infoType, String tag, String alias, String registrationId, String alert, String title, String contentMsg, String contentType, Map<String,String> map){
        boolean bool = false;
        PushResult result = push( infoType, tag, alias, registrationId, alert, title, contentMsg, contentType, map);
        if(result != null && result.isResultOK()){
            bool = true;
        }
        return bool;
    }

    /**
     * 极光推送方法(采用java SDK)
     * 如果 别名不为空 则根据别名推送 别名为空 设备编号不为空 按设备编号推送 两者均为空 默认推送所有用户
     * @param infoType 0.通知推送 1.自定义推送 （infoType=0 title contentMsg contentType extra_key extra_value 可不传）（infoType=1 alert 可不传）
     * @param alias 别名
     * @param registrationId 设备编号
     * @param alert 通知推送内容
     * @param title 自定义推送标题
     * @param contentMsg 自定义推送内容
     * @param contentType 自定义推送类型
     * @param map 附加字段map
     * @return
     */
    public static PushResult push(int infoType, String tag, String alias, String registrationId, String alert, String title, String contentMsg, String contentType, Map<String,String> map){
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
        PushPayload payload = null;
        if (infoType == 0){
            if (StringUtils.isNotBlank(tag)){
                payload = buildPushObject_notice_tag_info(tag,alert);
            } else if (StringUtils.isNotBlank(alias)){
                payload = buildPushObject_notice_alias_info(alias,alert);
            } else if (StringUtils.isNotBlank(registrationId)){
                payload = buildPushObject_notice_single_info(registrationId,alert);
            }else {
                payload = buildPushObject_notice_all_info(alert);
            }
        }else {
            if (StringUtils.isNotBlank(tag)){
                payload = buildPushObject_custom_tag_info(tag,title,contentMsg,contentType,map);
            } else if (StringUtils.isNotBlank(alias)){
                payload = buildPushObject_custom_alias_info(alias,title,contentMsg,contentType,map);
            } else if (StringUtils.isNotBlank(registrationId)){
                payload = buildPushObject_custom_single_info(registrationId,title,contentMsg,contentType,map);
            }
        }

        try {
            return jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            return null;
        }
    }


    /**
     * 自定义推送到指定标签设备
     * @param tag
     * @param title
     * @param content_msg
     * @param contentType
     * @param map
     * @return
     */
    public static PushPayload buildPushObject_custom_tag_info(String tag, String title, String content_msg, String contentType, Map<String,String> map) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setMessage(Message.newBuilder()
                        .setTitle(title)
                        .setMsgContent(content_msg)
                        .setContentType(contentType)
                        .addExtras(map)
                        .build())
                .build();
    }

    /**
     * 自定义推送到指定别名设备
     * @param alias
     * @param title
     * @param content_msg
     * @param contentType
     * @param map
     * @return
     */
    public static PushPayload buildPushObject_custom_alias_info(String alias, String title, String content_msg, String contentType, Map<String,String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder()
                        .setTitle(title)
                        .setMsgContent(content_msg)
                        .setContentType(contentType)
                        .addExtras(map)
                        .build())
                .build();
    }

    /**
     * 自定义推送到指定设备
     * @param registrationId
     * @param title
     * @param content_msg
     * @param contentType
     * @param map
     * @return
     */
    public static PushPayload buildPushObject_custom_single_info(String registrationId, String title, String content_msg, String contentType, Map<String,String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationId))
                .setMessage(Message.newBuilder()
                        .setTitle(title)
                        .setMsgContent(content_msg)
                        .setContentType(contentType)
                        .addExtras(map)
                        .build())
                .build();
    }

    /**
     * 通知推送到指定标签设备
     * @param tag
     * @param alert
     * @return
     */
    public static PushPayload buildPushObject_notice_tag_info(String tag, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.alert(alert))
                .build();
    }

    /**
     * 通知推送到指定别名设备
     * @param alias
     * @param alert
     * @return
     */
    public static PushPayload buildPushObject_notice_alias_info(String alias, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }

    /**
     * 通知推送到指定设备
     * @param registrationId
     * @param alert
     * @return
     */
    public static PushPayload buildPushObject_notice_single_info(String registrationId, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationId))
                .setNotification(Notification.alert(alert))
                .build();
    }

    /**
     * 快捷推送到所有平台
     * @return
     */
    public static PushPayload buildPushObject_notice_all_info(String alert) {
        return PushPayload.alertAll(alert);
    }

}
