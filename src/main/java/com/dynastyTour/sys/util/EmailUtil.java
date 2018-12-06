package com.dynastyTour.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.dynastyTour.sys.condition.SchedulerCondition;

@Component
public class EmailUtil {
	private final Logger logger = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
    private JavaMailSender mailSender; 
	
	@Value("${email.enabled}")
	private Boolean sendEmail;
	
	public void sendEmail(SimpleMailMessage message) {
		if (sendEmail) {
			mailSender.send(message);
		} else {
			logger.info("不允许发送Email");
		}
	}
}
