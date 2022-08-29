package com.example.learnmq.task;

import com.example.learnmq.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: Spark
 * @CreateTime: 2022-08-29
 * @Description: TODO
 */
@Component
@RabbitListener(queues = {RabbitConfig.QUEUE_USER})
public class MsgReceiver3 {

    @RabbitHandler
    public void receive(String msg, Message message, Channel channel) {
        System.out.println("[QUEUE_USER]message queue: ["+RabbitConfig.QUEUE_CITY+"], receive2 msg: ["+msg+"]");
    }
}
