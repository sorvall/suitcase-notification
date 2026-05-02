package ru.sorokin.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotifier {

    private static final Logger log = LoggerFactory.getLogger(EmailNotifier.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${notification.email.to}")
    private String to;

    @Value("${notification.email.subject}")
    private String subject;

    public EmailNotifier(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            mailSender.send(message);
        } catch (MailException ex) {
            // Не пробрасываем: иначе Rabbit будет бесконечно переотправлять при неверном пароле SMTP
            log.error(
                    "SMTP failed (Яндекс: пароль приложения в id.yandex.ru, логин = полный e-mail; MAIL_PASSWORD в Docker): {}",
                    ex.getMessage());
        }
    }
}
