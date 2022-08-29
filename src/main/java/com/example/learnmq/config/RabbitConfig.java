package com.example.learnmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Spark
 * @CreateTime: 2022-08-29
 * @Description: TODO
 */
@Configuration
public class RabbitConfig {

    public final static String EXCHANGE_TOPIC = "topicExchange";
    public final static String QUEUE_USER = "user_Queue";
    public final static String QUEUE_CITY = "city_Queue";
    public final static String QUEUE_DEVICE = "device_Queue";
    public final static String BINDINGKEY_ONE = "topic.a";
    public final static String BINDINGKEY_OTHER = "other.#";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_TOPIC);
    }

    @Bean(name = RabbitConfig.QUEUE_USER)
    Queue userQueue() {
        return new Queue(QUEUE_USER);
    }

    @Bean(name = RabbitConfig.QUEUE_CITY)
    Queue cityQueue() {
        return new Queue(QUEUE_CITY);
    }

    @Bean(name = RabbitConfig.QUEUE_DEVICE)
    Queue deviceQueue() {
        return new Queue(QUEUE_DEVICE);
    }

    @Bean
    Binding userBinding(@Qualifier(RabbitConfig.QUEUE_USER) Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(BINDINGKEY_ONE);
    }

    @Bean
    Binding cityBinding(@Qualifier(RabbitConfig.QUEUE_CITY) Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(BINDINGKEY_OTHER);
    }

    @Bean
    Binding deviceBinding(@Qualifier(RabbitConfig.QUEUE_DEVICE) Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(BINDINGKEY_OTHER);
    }

}
