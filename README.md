# Название проекта

Backend продукта [vizhu.online](https://vizhu.online)

## Предварительные требования

- [Docker](https://www.docker.com/products/docker-desktop) (для создания и запуска контейнеров)
- Postgre SQL port:5430, name: vizhuBD


## Запуск приложения
```
docker build -t myapp:latest .
docker run -p 8080:8081 myapp:latest
```