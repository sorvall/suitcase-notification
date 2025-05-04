package ru.sorokin.notification.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    public static final String TELEGRAM_QUEUE = "telegram.queue";

    @Bean
    public Queue telegramQueue() {
        return new Queue(TELEGRAM_QUEUE, true); // durable
    }
}
