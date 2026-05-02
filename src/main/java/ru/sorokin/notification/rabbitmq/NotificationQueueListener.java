package ru.sorokin.notification.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.sorokin.notification.service.EmailNotifier;

import java.io.IOException;

@Service
public class NotificationQueueListener {

    private final ObjectMapper mapper = new ObjectMapper();
    private final EmailNotifier emailNotifier;

    public NotificationQueueListener(EmailNotifier emailNotifier) {
        this.emailNotifier = emailNotifier;
    }

    @RabbitListener(queues = "${notification.rabbit.incoming-queue}")
    public void receiveMessage(Message message) throws IOException {
        String messageBody = mapper.readValue(message.getBody(), String.class);
        emailNotifier.sendMessage(messageBody);
    }
}
