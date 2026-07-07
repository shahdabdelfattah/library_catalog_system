# Intern Project Requirements: Spring Boot CRUD and GitHub Workflow

## 1. Project Goal

Create Java Spring Boot CRUD application and manage the full development lifecycle using GitHub.
Each intern must create their own GitHub repository and invite the mentor as a collaborator.

## 2. Project Theme

The project theme is a simple library catalog system.

The application should mainly use two entities:

- Author
- Book

The application should include two main business features and one final improvement phase. Interns are responsible for designing the `Author` and `Book` model/entity classes needed for their implementation.

## 3. Technical Requirements

### 3.1 Backend Framework

The project must be built with:

- Java 17 or later
- Spring Boot
- Spring Web
- Spring Data JPA
- A relational database such as H2, PostgreSQL, or MySQL
- Maven or Gradle

### 3.2 Project Structure

The application must follow a clean Spring Boot package structure. A recommended structure is:

```text
src/main/java/com/example/projectname
|-- config
|-- controller
|-- dto
|-- entity
|-- exception
|-- mapper
|-- repository
|-- service
`-- ProjectApplication.java
```

APIs should use correct HTTP methods
APIs should return appropriate HTTP status codes.

### 3.5 DTOs and Data Mapping

The application must use DTOs for API input and output.
Interns should not expose JPA entities directly from controllers.

### 3.6 Exception Handling

The application must include general exception handling using `@ControllerAdvice` or `@RestControllerAdvice`.

Expected exception handling includes:

- Resource not found
- Validation errors
- Duplicate or invalid business data
- Unexpected server errors

Error responses should be consistent, standardized and easy to understand. 

### 3.7 Validation

The project should use Bean Validation where appropriate.

## 4. Development Phases

The project must be developed in phases. Each phase should be visible in GitHub through branches, pull requests or merge commits, and commit history.

### Phase 0: Project Setup

Create the initial Spring Boot project and push it to GitHub.

Required tasks:

- Create a new Spring Boot application.
- Configure dependencies.
- Configure database connection.
- Add an initial `README.md`.
- Add `.gitignore` suitable for Java/Spring Boot.
- Push the initial project to the `main` branch.

Expected branch:

```text
main
```

### Phase 1: Feature One

Create the first main CRUD feature.

Suggested feature:

- Author management

Example functionality:

- Create author
- Get author by ID
- List authors
- Update author details
- Delete author

Expected branch:

```text
feature/author-management
```

### Phase 2: Feature Two

Create the second main business feature.

Suggested feature:

- Book management

Example functionality:

- Create book
- Get book by ID
- List books
- List books for an author
- Update book details
- Delete book

Expected branch:

```text
feature/book-management
```

### Phase 3: Enhancements, Refactoring, and Git Conflict Practice

The final phase should improve the codebase and introduce Git workflow practice.

Required tasks:

- Introduce DTOs or mapper logic.
- Introduce exception handling.
- Improve naming or package organization if needed.
- Update documentation/ Readme.
- Improve error responses.
- Add missing validation.

Expected branches :intermediate branches for merging/ resolving conflicts:

The final Git history should clearly show the branches and merge commits.

## 5. Git and GitHub Requirements

Each intern must create their own GitHub repository.

Repository requirements:

- The repository must be public or shared with the mentor.
- The mentor must be invited as a collaborator.
- The repository must include a clear `README.md`.
- The repository must show separate branches for each feature.
- Feature branches must be merged into `main`.
- Merge commits should be visible in the commit history.
- Commit messages should be clear and meaningful.

Interns should avoid committing generated files, build folders, IDE-specific files, or secrets.

## 6. README Requirements

The project repository must include a `README.md`.

## 7. API Documentation

Interns should document their APIs using

- Swagger/OpenAPI using Springdoc

Testing evidence can be included in the README through sample requests and responses.


## 8. Submission Instructions

Each intern must submit:

- GitHub repository URL with mentor invited as a collaborator.
- Short explanation of the resolved Git conflict.

