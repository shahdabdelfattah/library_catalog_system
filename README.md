# Library System

A simple Library Catalog System built with Spring Boot as part of the Ejada internship project. The application manages Authors and Books, exposing a full CRUD REST API.

## Tech Stack

- **Java 26**
- **Spring Boot 4.1.0**
- **PostgreSQL** (relational database)
- **Maven** (build tool)
- **Springdoc OpenAPI** (Swagger UI for API documentation)

## Project Structure
```
src/main/java/com/example/library_system
├── controller
│   ├── AuthorController.java
│   └── BookController.java
├── dto
│   ├── BookRequestDTO.java
│   ├── BookResponseDTO.java
│   ├── BookSummaryDTO.java
│   ├── AuthorRequestDTO.java
│   └── AuthorResponseDTO.java
├── entity
│   ├── Author.java              
│   └── Book.java 
├── mapper
│   ├── AuthorMapper.java
│   └── BookMapper.java
├── repository
│   ├── AuthorRepository.java
│   └── BookRepository.java
├── service
│   ├── AuthorService.java
│   └── BookService.java
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   ├── DuplicateResourceException.java
│   └── ErrorResponse.java
└── LibrarySystemApplication.java
```

## Getting Started

### 1. Create the database

```bash
psql -U postgres -h localhost -p 5432
```

```sql
CREATE DATABASE library_db;
```

### 2. Configure the connection

Edit `src/main/resources/application.yml` with your local Postgres credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/db_name
    username: your_username
    password: your_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

### 4. API Documentation (Swagger)

Once running, interactive API docs are available at:

```
http://localhost:8080/swagger-ui.html
```

## API Reference

### Authors

| Method | Endpoint             | Description                          |
|--------|-----------------------|---------------------------------------|
| POST   | `/authors`             | Create a new author                   |
| GET    | `/authors`             | List all authors                      |
| GET    | `/authors/{id}`        | Get a single author by ID             |
| PUT    | `/authors/{id}`        | Update an existing author             |
| DELETE | `/authors/{id}`        | Delete an author                      |
| GET    | `/authors/{id}/books`  | List all books written by an author   |

### Books

| Method | Endpoint          | Description                     |
|--------|-------------------|----------------------------------|
| POST   | `/books`           | Create a new book                |
| GET    | `/books`           | List all books                   |
| GET    | `/books/{id}`       | Get a single book by ID          |
| PUT    | `/books/{id}`       | Update an existing book          |
| DELETE | `/books/{id}`       | Delete a book                    |

## Sample Requests

### Create an Author

**Request**
```http
POST /authors

{
  "name": "J.K. Rowling",
  "birthDate": "1965-07-31"
}
```

**Response** `201 Created`
```json
{
  "id": 1,
  "name": "J.K. Rowling",
  "birthDate": "1965-07-31",
  "books": []
}
```

### Create a Book

**Request**
```http
POST /books

{
  "title": "Harry Potter and the Philosopher's Stone",
  "genre": "Fantasy",
  "publishDate": "1997-06-26",
  "authorId": 1
}
```

**Response** `201 Created`
```json
{
  "id": 1,
  "title": "Harry Potter and the Philosopher's Stone",
  "genre": "Fantasy",
  "publishDate": "1997-06-26",
  "authorId": 1,
  "authorName": "J.K. Rowling"
}
```

### Validation Error Example

**Request**
```http
POST /authors

{
  "name": "",
  "birthDate": "1965-07-31"
}
```

**Response** `400 Bad Request`
```json
{
  "timestamp": "2026-07-09T10:15:30",
  "status": 400,
  "error": "Validation Failed",
  "message": "One or more fields are invalid",
  "details": [
    "Name is required"
  ]
}
```

### Not Found Error Example

**Request**
```http
GET /authors/999
```

**Response** `404 Not Found`
```json
{
  "timestamp": "2026-07-09T10:16:02",
  "status": 404,
  "error": "Not Found",
  "message": "Author not found with id: 999",
  "details": null
}
```

### Duplicate Resource Error Example

**Request**
```http
POST /authors

{
  "name": "J.K. Rowling",
  "birthDate": "1965-07-31"
}
```

**Response** `409 Conflict`
```json
{
  "timestamp": "2026-07-09T10:17:40",
  "status": 409,
  "error": "Conflict",
  "message": "An author named 'J.K. Rowling' already exists",
  "details": null
}
```

## Author

Shahd Abdelfatah— Backend Intern, Ejada Systems Integration Team
