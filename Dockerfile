# Используйте официальный образ Java как базовый
FROM openjdk:17-jdk

# Установите рабочую директорию внутри контейнера
WORKDIR /app

# Скопируйте собранный JAR файл в контейнер
COPY vizhu/target/vizhu-0.0.1.jar /app/myapp.jar

# Задайте команду для запуска приложения
CMD ["java", "-jar", "myapp.jar"]
