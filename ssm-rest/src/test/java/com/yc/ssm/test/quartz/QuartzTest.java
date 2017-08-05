package com.yc.ssm.test.quartz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by YC on 2017/7/24.
 */
public class QuartzTest {
    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/quartz-context.xml");
    }
}
