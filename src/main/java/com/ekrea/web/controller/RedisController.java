package com.ekrea.web.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月19日 上午10:08:13 
* @version 1.0 
* @description 
*/
@RestController
@RequestMapping("redis")
public class RedisController {
	
	
/*
 	redisTemplate.opsForValue();//操作字符串
	redisTemplate.opsForHash();//操作hash
	redisTemplate.opsForList();//操作list
	redisTemplate.opsForSet();//操作set
	redisTemplate.opsForZSet();//操作有序set
*/	
	@Autowired
    protected RedisTemplate<String, String> redisTemplate;
	@RequestMapping("get")
	public Object getRedis() {
		redisTemplate.opsForValue();//操作String
		//set:设置String的值
		redisTemplate.opsForValue().set("name", "zhuming");
		//append:追加字符串
		redisTemplate.opsForValue().append("name", "zhuming");
		//setIfAbsent：判断之前是否存在，存在false,不存在true,并且插。
		System.out.println(redisTemplate.opsForValue().setIfAbsent("name", "zhuming"));
//		System.out.println(redisTemplate.opsForValue().setIfAbsent("name1", "zhuming1231"));
		
		
		redisTemplate.opsForHash();//操作hash
		
		
		
		redisTemplate.opsForList();//操作list
//		redisTemplate.opsForList().rightPush("like", "{ \"total\": 1,\"rows\": [{\"casNum\": \"1031-47-6\" }]}");
		//range展示所有的redisLIST中的数据
		System.out.println(redisTemplate.opsForList().range("like", 0, -1));
		//获取list的大小
		System.out.println(redisTemplate.opsForList().size("like"));
		
		
		redisTemplate.opsForSet();//操作set
		
		
		
		
		redisTemplate.opsForZSet();//操作有序set
		
		Object a =	redisTemplate.opsForValue().get("name");
		System.out.println(a);
		return null;	
	}
}
