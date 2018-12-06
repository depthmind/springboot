package com.dynastyTour.sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.EndDocument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dynastyTour.sys.util.EmailUtil;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private Environment env;
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/getProfile.do")
	public ModelAndView test(ModelAndView modelAndView) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@tourmade.com");
        message.setTo("13641716360@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
		
		modelAndView.setViewName("index/index");
		List<String> userList=new ArrayList<String>();
		
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");
        
        logger.info("==========hhhhh==========");
        emailUtil.sendEmail(message);
        
        logger.info(env.getProperty("schedule.enabled"));
        modelAndView.addObject("userList", userList);
        return modelAndView;
	}
}
