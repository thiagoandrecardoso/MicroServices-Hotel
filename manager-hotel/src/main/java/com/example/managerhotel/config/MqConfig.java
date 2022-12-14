package com.example.managerhotel.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Value("${mq.queues.cursomsrabbitmq}")
    private String requestRoomMq;

    @Bean
    public Queue queueRequestRoom() {
        return new Queue(requestRoomMq, true);
    }
}