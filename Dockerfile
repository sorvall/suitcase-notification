# Используем официальный образ OpenJDK
FROM openjdk:21-jdk-slim

# Указываем рабочую директорию в контейнере
WORKDIR /app

# Копируем JAR файл в контейнер
COPY build/libs/suitcase-notification-0.0.1-SNAPSHOT.jar /app/suitcase-notification.jar

# Открываем порт, если приложение использует порты (например, 8080)
EXPOSE 8082

# Запускаем JAR файл
CMD ["java", "-jar", "suitcase-notification.jar"]