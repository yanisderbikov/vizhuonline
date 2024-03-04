# Название проекта

Краткое описание вашего проекта.

## Предварительные требования

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) (рекомендуется версия 17)
- [Maven](https://maven.apache.org/download.cgi) (для сборки проекта)
- [Docker](https://www.docker.com/products/docker-desktop) (для создания и запуска контейнеров)

## Сборка проекта

Чтобы собрать JAR файл вашего приложения, выполните следующую команду в терминале:

```bash
mvn clean install
```

## Запуск приложения
```
docker build -t myapp:latest .
docker run -p 8080:8080 myapp:latest
```