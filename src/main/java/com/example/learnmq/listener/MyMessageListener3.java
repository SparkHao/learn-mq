package com.example.learnmq.listener;

import com.example.learnmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: Spark
 * @CreateTime: 2022-08-29
 * @Description: TODO
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_USER)
public class MyMessageListener3 {

    @RabbitHandler
    public void handler(String message) {
        System.out.println("[QUEUE_USER]MyMessageListener3 receive msg: {}" + message);
    }
}
