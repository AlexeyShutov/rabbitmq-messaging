package com.messaging.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Consumer {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void onMessage(String message) {
        logger.info("{} - received at {}", message, LocalDateTime.now());
    }

}
