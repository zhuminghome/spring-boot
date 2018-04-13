package com.ekrea.web.controller;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月12日 下午3:57:40 
* @version 1.0 
* @description 邮件发送
*/
@RestController
@RequestMapping("send")
public class SendMsgController {
		@Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String username;
	    @RequestMapping("msg")
		public String testSendSimple() {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(username);
	        message.setTo("1073411198@qq.com");
	        message.setSubject("你好");
	        message.setText("你好");
	        javaMailSender.send(message);
			return "发送成功";
	    }
	    @RequestMapping("msg0")
	    public String testSendByName() {
	        MimeMessage message = null;
	        try {
	            message = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setFrom(new InternetAddress(username, "阿里巴巴", "UTF-8"));
	            helper.setTo("1050727309@qq.com");
	            helper.setSubject("OFFER");

	            StringBuffer sb = new StringBuffer();
	            sb.append("<h1>OFFER</h1>")
	                    .append("<p style='color:#F00'>您已经被成功录用</p>")
	                    .append("<p style='text-align:right'>阿里巴巴</p>");
	            helper.setText(sb.toString(), true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        javaMailSender.send(message);
	        return "发送成功";
	    }
}
