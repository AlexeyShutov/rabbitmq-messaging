package com.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApp implements CommandLineRunner {

    @Value("${producer.default-generate-count}")
    private int messagesCount;
    @Value("${producer.delay-between-generations}")
    private int delay;

    @Autowired
    private Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class, args);
    }

    @Override
    public void run(String... args) {
        producer.produceRandomMessagesPeriodically(messagesCount, delay);
    }

}
