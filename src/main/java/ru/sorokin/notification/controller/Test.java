package ru.sorokin.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class Test {

    @GetMapping("/check")
    public String get() {
        // telegramNotifier.sendMessage("Hello World");
        return "Hello World";
    }
}
