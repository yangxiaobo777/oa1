package com.yang.oa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [定时任务线程池]
 * @createTime :[2022/3/30 22:52]
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(30);
        scheduler.initialize();
        taskRegistrar.setTaskScheduler(scheduler);
    }
}
