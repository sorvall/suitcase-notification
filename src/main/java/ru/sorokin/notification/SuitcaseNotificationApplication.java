package ru.sorokin.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// @EnableFeignClients
public class SuitcaseNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuitcaseNotificationApplication.class, args);
	}

}
