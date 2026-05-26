Система управления обновлениями приложений

Проект для лабораторных работ по Spring Boot. Позволяет управлять версиями приложения для разных платформ (Android, iOS, Windows), проверять обновления для устройств и собирать статистику установок.

Зачем это нужно

Когда приложение используется на тысячах устройств, сложно отслеживать, кто на какой версии. Нужно иметь возможность выпускать принудительные, рекомендованные или отложенные обновления, а также видеть, сколько пользователей уже перешли на новую версию. Всё это реализовано.

Используемые технологии

Java 17
Spring Boot 3.3.4
Spring Security + JWT (аутентификация)
Spring Data JPA / Hibernate
PostgreSQL
Lombok
Swagger (springdoc-openapi)
Maven

Как запустить

1. Установить PostgreSQL (версия 17), создать базу данных с именем update_system.
2. Склонировать репозиторий: git clone https://github.com/student2232122SNA/update-system.git
3. Открыть проект в IntelliJ IDEA, дождаться загрузки зависимостей.
4. В файле src/main/resources/application.yaml при необходимости поменять пароль от PostgreSQL.
5. Запустить DemoApplication.java.
6. Приложение будет доступно на http://localhost:8080.

Документация Swagger: http://localhost:8080/swagger-ui/index.html

API эндпоинты

Регистрация пользователя
POST /api/auth/register
Тело: {"username": "admin", "password": "admin123"}

Логин (получение JWT токена)
POST /api/auth/login
Тело: {"username": "admin", "password": "admin123"}
В ответе приходит token, который нужно использовать в заголовке Authorization: Bearer <token>

Добавление новой версии
POST /api/versions
Заголовок: Authorization: Bearer <token>
Тело: {"version": "2.0.0", "platform": "android", "changelog": "текст изменений", "updateType": "OPTIONAL"}

Получение последней версии для платформы
GET /api/versions/latest?platform=android

Проверка обновления для устройства
GET /api/update/check?userId=123&current=1.0.0&platform=android
Заголовок: Authorization: Bearer <token>

Лог установки обновления
POST /api/update/log?userId=123&platform=android&newVersion=2.0.0

Статистика распространения версий
GET /api/stats/updates
Заголовок: Authorization: Bearer <token>

Что не доделано

Экспорт отчётов в Excel (зависимость Apache POI добавлена, но эндпоинт не завершён).
Уведомления в Telegram.
Тепловая карта распространения версий по платформам.
Полноценная работа JWT в текущей версии упрощена для удобства проверки – проверка токена настроена, но в SecurityConfig временно разрешены все запросы. В реальном проекте нужно включить полную авторизацию.

Ссылка на репозиторий: https://github.com/student2232122SNA/update-system

