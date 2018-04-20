package com.ekrea.web.controller;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月20日 上午11:51:12 
* @version 1.0 
* @description 
*/
@Component
public class RabbitMqReceiver {
	    @RabbitListener(queues = "doc_msg")
	    public void process(Message lll) {
	    	 JSONObject jsonObject = JSON.parseObject(new String(lll.getBody()));
			 System.out.println("Receiver  : " + jsonObject);
	       
	    }
}
