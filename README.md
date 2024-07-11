# Java RESTful API

A small project aimed at learning a new language (Java), a new framework (Spring Boot), and new coding patterns, as well as further exploring object oriented programming, a programming paradigm that has always sparked my curiosity.

## How it works

This project has been set up with Spring Boot and is being built following the controller-service-repository pattern.

A Postgres database has been connected through Spring Boot and is being managed with [Liquibase](https://www.liquibase.com/).

## Endpoints

### /topics

- **GET 200**: Responds with a list of all the topics.

  - Response example:

  ```java
  [
    {
        "id": "c3ef6093-3a8a-4f05-8604-c17401fa8fbb",
        "slug": "Cooking",
        "description": "A good dish soothes the soul."
    },
    {
        "id": "55c68700-9389-4251-be4b-2f5d33124cb1",
        "slug": "Mocha",
        "description": "The best doggo."
    },
    {
        "id": "54d39edf-7f59-48bf-8c2a-caef5fe7e932",
        "slug": "Travelling",
        "description": "Discover the world."
    }
  ]
  ```

- **POST 201**: Responds with the posted topic object.

  - Response example:

  ```java
  [
    {
        "id": "55c68700-9389-4251-be4b-2f5d33124cb1",
        "slug": "Mocha",
        "description": "The best doggo."
    }
  ]
  ```

### /topics/{id}

- **GET 200**: Responds with the matched topic.

  - Response example:

  ```java
  [
    {
        "id": "c3ef6093-3a8a-4f05-8604-c17401fa8fbb",
        "slug": "Cooking",
        "description": "A good dish soothes the soul."
    }
  ]
  ```

- **DELETE 402**: Deletes the matched topic. Does not return anything.
