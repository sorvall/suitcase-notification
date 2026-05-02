package ru.sorokin.notification.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.sorokin.notification.configuration.RabbitMQConfiguration;
import ru.sorokin.notification.service.EmailNotifier;
import ru.sorokin.notification.service.TelegramNotifier;

import java.io.IOException;

@Service
public class TelegramQueueListener {
    private final ObjectMapper mapper = new ObjectMapper();

    private final TelegramNotifier telegramNotifier;
    private final EmailNotifier emailNotifier;

    public TelegramQueueListener(TelegramNotifier telegramNotifier, EmailNotifier emailNotifier) {
        this.telegramNotifier = telegramNotifier;
        this.emailNotifier = emailNotifier;
    }

    @RabbitListener(queues = RabbitMQConfiguration.TELEGRAM_QUEUE)
    public void receiveMessage(Message message) throws IOException {
        String messageBody = mapper.readValue(message.getBody(), String.class);
        telegramNotifier.sendMessage(messageBody);
        emailNotifier.sendMessage(messageBody);
    }
}
