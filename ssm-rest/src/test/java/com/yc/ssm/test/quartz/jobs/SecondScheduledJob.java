package com.yc.ssm.test.quartz.jobs;

import com.yc.ssm.util.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by YC on 2017/7/24.
 */
public class SecondScheduledJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println();
        Date date = new Date();
        String dateStr = DateUtil.dateToString(date,DateUtil.YYYY_MM_DD_HH_MM_SS);
        System.out.println("I am SecondScheduledJob:" + dateStr);
    }
}
