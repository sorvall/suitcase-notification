package ru.sorokin.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sorokin.notification.service.TelegramNotifier;

@RestController
@RequestMapping("/availability")
public class Test {

    private final TelegramNotifier telegramNotifier;

    public Test(TelegramNotifier telegramNotifier) {
        this.telegramNotifier = telegramNotifier;
    }

    @GetMapping("/check")
    public String get() {
        telegramNotifier.sendMessage("Hello World");
        return "Hello World";
    }
}
