package com.example.learnmq;

import com.example.learnmq.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LearnMqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void sendMsg() {
        System.out.println("------------------------");
        for (int i=0;i< 5;i++) {
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, "msg", "message from test: {}" + i);
            rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_CITY, "[city]message from test: " + i);
        }
    }

}
