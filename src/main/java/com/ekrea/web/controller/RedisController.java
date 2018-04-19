package com.ekrea.web.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekrea.utils.RedisUtil;

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
*/	@SuppressWarnings("rawtypes")
	@Autowired
    protected RedisTemplate redisTemplate;
	@SuppressWarnings("unchecked")
	@RequestMapping("get")
	public Object getRedis() {
		redisTemplate.opsForList().rightPush("like", "{ \"total\": 1,\"rows\": [{\"casNum\": \"1031-47-6\" }]}");
		redisTemplate.opsForValue().set("name", "zhuming", 50, TimeUnit.SECONDS);
		redisTemplate.opsForHash();//操作hash
		redisTemplate.opsForList();//操作list
		redisTemplate.opsForSet();//操作set
		redisTemplate.opsForZSet();//操作有序set
		
		Object a =	redisTemplate.opsForValue().get("name");
		System.out.println(a);
		return redisTemplate.opsForList().rightPop("like");	
	}
}
