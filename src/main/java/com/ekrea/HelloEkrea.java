package com.ekrea;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekrea.model.User;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月9日 下午4:19:16 
* @version 1.0 
* @description 
*/
@RestController
@RequestMapping("user")
public class HelloEkrea {

	@RequestMapping("get")
	public User getUser() {
		User user = new User();
		user.setName("ekrea");
		user.setPassword("12346");
		user.setBirthday(new Date());
		return user;
	}
}
