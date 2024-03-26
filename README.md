# Название проекта

Backend продукта [vizhu.online](https://vizhu.online)

## Предварительные требования

- [Docker](https://www.docker.com/products/docker-desktop) 
(для создания и запуска контейнеров)
- Docker Compose
- Postgre SQL 
  - port: localhost:5430 
  - name: vizhuBD 
  - username: yander
  - password: yander_login
- Установка секретного ключа командой 
```node -e "console.log(require('crypto').randomBytes(32).toString('hex'))"``` вставкой в поле [token.secret.key](src/main/resources/application.properties) либо любой другой секретный ключ


## Сборка проекта 

Если версия jar файла в папке jars не актуальна:
1. ```mvn clean install```
2. перенести jar-файл из папки [target](target) в папку [jars](jars)
3. запустить приложение

## Запуск приложения
1. Запустить контейнер PostgreSQL, если он не запущен.  
2. Описать переменные окружения в том же месте, где находится docker-compose. ([пример для файла .env](.env.dist))
3. Запустить docker compose командой ```docker-compose up --build ```