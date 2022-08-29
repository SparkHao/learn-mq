package com.example.learnmq.task;

import com.example.learnmq.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Auther: Spark
 * @CreateTime: 2022-08-29
 * @Description: TODO
 */
@Component
public class RabbitSendTask implements ApplicationRunner {

    private Logger log = LoggerFactory.getLogger(RabbitSendTask.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("rabbit send task");
        log.info("[{}] start send msg", "RabbitSendTask");
        for(int i = 0 ;i < 10; i++) {
            amqpTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, RabbitConfig.BINDINGKEY_OTHER, "message: msg from learn-rabbit OTHER");
            if (i % 2 == 0){
                amqpTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, RabbitConfig.BINDINGKEY_ONE, "message: msg from learn-rabbit ONE");
            }
        }
        System.out.println("----------------");
    }
}
