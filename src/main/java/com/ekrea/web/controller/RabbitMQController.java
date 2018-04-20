package com.ekrea.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ekrea.service.MessageQueueService;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月20日 上午11:27:06 
* @version 1.0 
* @description 
*/
@RestController
@RequestMapping("rabbit")
public class RabbitMQController {
	@Autowired
	private MessageQueueService queue;
	@RequestMapping("send")
	public void sendMsg() {
		JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("docId", "1");
        jsonObject1.put("hospitalCode", "1002");
        jsonObject1.put("departmentCode", "1");
		queue.sendMsg("doc_msg", jsonObject1.toString());
	}
}
