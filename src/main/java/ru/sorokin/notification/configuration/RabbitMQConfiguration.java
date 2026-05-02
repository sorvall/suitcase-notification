package ru.sorokin.notification.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue notificationQueue(@Value("${notification.rabbit.incoming-queue}") String queueName) {
        return new Queue(queueName, true);
    }
}
