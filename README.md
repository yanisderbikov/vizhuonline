# Название проекта

Backend продукта [vizhu.online](https://vizhu.online)

## Предварительные требования

- [Docker](https://www.docker.com/products/docker-desktop) 
(для создания и запуска контейнеров)
- Postgre SQL 
  - port: localhost:5430 
  - name: vizhuBD 
  - username: yander
  - password: yander_login

## Сборка проекта 

Если версия jar файла в папке jars не актуальна:
1. ```mvn clean install```
2. перенести jar-файл из папки [target](target) в папку [jars](jars)
3. запустить приложение

## Запуск приложения
```
docker-compose up --build
```