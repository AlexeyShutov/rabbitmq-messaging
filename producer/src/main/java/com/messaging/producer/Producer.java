package com.messaging.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Producer {

    @Value("${producer.connection.retry-delay}")
    private long retryDelay;

    private static Logger logger = LoggerFactory.getLogger(Producer.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceRandomMessagesPeriodically(int count, int delay) {
        while (true) {
            try {
                produceRandomMessages(count);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn("Message producing interrupted");
                return;
            }
        }
    }

    public void produceRandomMessages(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                rabbitTemplate.convertAndSend("Message " + ThreadLocalRandom.current().nextInt());
            } catch (AmqpConnectException e) {
                    logger.warn(e.getMessage());
                    Thread.sleep(retryDelay);
                    i--;
            }
        }
        logger.info("{} messages produced", count);
    }

}
