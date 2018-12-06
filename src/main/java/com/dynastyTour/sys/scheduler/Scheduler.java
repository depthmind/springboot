package com.dynastyTour.sys.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.TaskManagementConfigUtils;
import org.springframework.stereotype.Component;

import com.dynastyTour.sys.condition.SchedulerCondition;

@Component
@Conditional(SchedulerCondition.class)
@EnableScheduling
public class Scheduler {
	private final Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
	@Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
		logger.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
}
