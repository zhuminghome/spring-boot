package com.ekrea.service;


/**
 * Created by zhuming on 2016/11/12.
 */

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageQueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queue, String msg) {
        rabbitTemplate.convertAndSend(queue, msg);
    }

}
