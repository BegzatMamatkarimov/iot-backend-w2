# IoT Backend Platform — Задание №2

## Описание проекта

Это мой бэкенд-проект на **Spring Boot** и **PostgreSQL**.
В этом задании я добавил систему **пользователей**, **авторизацию через JWT**, и связал пользователей с их **устройствами (Device)**.

Теперь каждый пользователь может:

* зарегистрироваться и войти в систему,
* добавлять свои устройства,
* редактировать и удалять **только свои** устройства,
* видеть все устройства, добавленные другими пользователями.

---

## Технологии

* Java 17
* Spring Boot 3.5.6
* Spring Security + JWT
* Spring Data JPA + Hibernate
* PostgreSQL
* Maven

---

## Как запустить

### 1. Создать базу данных PostgreSQL

```sql
CREATE USER iot_user WITH PASSWORD 'iot_pass';
CREATE DATABASE iot_platform OWNER iot_user;
```

### 2. Настроить `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/iot_platform
spring.datasource.username=iot_user
spring.datasource.password=iot_pass
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

### 3. Запустить проект

```bash
mvn spring-boot:run
```

После запуска:
`http://localhost:8080`

---

## Авторизация

### Регистрация

`POST /api/auth/register`

```json
{
  "username": "beko",
  "password": "12345",
  "fullName": "Begzat"
}
```

### Логин

`POST /api/auth/login`

```json
{
  "username": "beko",
  "password": "12345"
}
```

Ответ вернёт токен:

```json
{"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."}
```

### Проверить текущего пользователя

`GET /api/auth/me`
в Header добавить:

```
Authorization: Bearer <твой_токен>
```

---

## Работа с устройствами

Все запросы ниже требуют токен.

### Добавить устройство

`POST /api/devices`

```json
{
  "name": "HumiditySensor",
  "model": "HS-300",
  "manufactureYear": 2025,
  "description": "Датчик влажности воздуха",
  "price": 35.5
}
```

### Получить список всех устройств

`GET /api/devices`

### Получить устройство по ID

`GET /api/devices/{id}`

### Обновить устройство (только автор)

`PUT /api/devices/{id}`

### Удалить устройство (только автор)

`DELETE /api/devices/{id}`

---

## Правила доступа

* Создавать устройства могут **только авторизованные пользователи**.
* Все пользователи видят общий список устройств.
* Редактировать и удалять может **только тот, кто создал устройство**.

---

## Что я сделал

* Реализовал регистрацию и логин с JWT.
* Добавил связь `User → Device` (один пользователь — много устройств).
* Ограничил доступ к редактированию/удалению только для автора.
* Все данные сохраняются в PostgreSQL.
* Сделал простую и понятную инструкцию в README.
