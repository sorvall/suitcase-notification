package ru.sorokin.notification.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MailEnvironmentWarning {

    private static final Logger log = LoggerFactory.getLogger(MailEnvironmentWarning.class);

    @Value("${spring.mail.password:}")
    private String mailPassword;

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        if (mailPassword == null || mailPassword.isBlank()) {
            log.error(
                    "spring.mail.password is empty — SMTP auth will fail (e.g. Yandex 535 Invalid format). "
                            + "Pass MAIL_PASSWORD into Docker (-e MAIL_PASSWORD=...) or set GitHub Actions secret.");
        }
    }
}
