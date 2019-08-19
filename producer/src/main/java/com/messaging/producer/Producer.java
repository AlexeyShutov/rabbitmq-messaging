package com.messaging.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceRandomMessage(int count) {
        for (int i = 0; i < count; i++) {
            rabbitTemplate.convertAndSend("Message " + ThreadLocalRandom.current().nextInt());
        }
    }

}
