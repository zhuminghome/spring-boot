package com.ekrea.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekrea.config.MyWebConfig;
import com.ekrea.model.User;

@RestController
@RequestMapping("user")
public class HelloAkreaController {
   @Autowired
   private MyWebConfig myWebConfig;
//   Environment 可以获取到配置文件中信息
   @Autowired
   private Environment env;
   @Value("${web.name}")
   private String name;
	
   SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	/**
	 * @author zming.BlueOcean
	 * @date 2018年4月12日 下午2:50:31 
	 * @return Observable
	 * @description spring-boot项目初测试
	 */
	@RequestMapping("get")
	public User getUser() {
		User user = new User();
		user.setName("akrea");
		user.setPassword("12346");
		user.setBirthday(new Date());
		return user;
	}
	/**
	 * @author zming.BlueOcean
	 * @date 2018年4月12日 下午2:49:57 
	 * @return Observable
	 * @description 注入到对象中获取配置信息
	 */
	@RequestMapping("properties")
	public String getProperties() {
		return myWebConfig.getAuthor()+"--"+myWebConfig.getName();
	}
	/**
	 * @author zming.BlueOcean
	 * @date 2018年4月12日 下午2:49:24 
	 * @return Observable
	 * @description 读取配置信息的两种方式
	 */
	@RequestMapping("environment")
	public String getEnvironment() {
		return env.getProperty("web.name")+"-----"+name;
	}
	
}
