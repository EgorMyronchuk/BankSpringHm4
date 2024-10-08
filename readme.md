## Міні проєкт "Клієнт-банк" (продовження)

Суть проєкту: створення прототипу панелі адміністратора для клієнт-банку програми.

## Testing, Spring security

## Завдання

- Протестувати роботу програми
- Підключити Spring Security

#### Технічні вимоги:

- Додати модульні тести для всіх методів контролерів та сервісів у додатку
- Підключити до проекту Spring Security
- Закрити доступ до всіх ендпоїнтів неавторизованим користувачам. Дозволяти отримувати інформацію лише після авторизації
- При створенні та збoереженні користувача в базу даних, автоматично кодувати його пароль, використовуючи одну з реалізацій PasswrdEncoder

#### Необов'язкове завдання просунутої складності:

- Написати також кілька тестів для перевірки роботи шару Dao/Repository. Для прогону цих тестів створити та приєднати базу даних H2
- Додати сторінку логіна на фронт-енд. Готовий шаблон можна знайти [тут](https://material-ui.com/getting-started/templates/)
- Додати можливість авторизації користувача за допомогою OAuth2.0 та сервісу Google

#### Література:
- [Тестування разом із Spring Boot. Частина 1](https://dan-it.gitlab.io/fs-book-ua/java-frameworks/testing1.html)
- [Тестування разом із Spring Boot. Частина 2](https://dan-it.gitlab.io/fs-book-ua/java-frameworks/testing2.html)
- [Introduction to Java Config for Spring Security](https://www.baeldung.com/java-config-spring-security)
