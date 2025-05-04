package ru.sorokin.notification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TelegramNotifier {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.chat.id}")
    private String chatId;

    private final TelegramClient telegramClient;

    public TelegramNotifier(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    public void sendMessage(String message) {
        telegramClient.sendMessage(token, chatId, message);
    }
}
