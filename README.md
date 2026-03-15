# Route Intelligence API

Route Intelligence API is a backend REST API built with **Java and Spring Boot** that allows users to create and manage routes composed of multiple geographic locations.

This project was developed as a **learning and practice exercise** to deepen my understanding of backend development concepts and technologies such as **Spring Boot, Lombok, JPA, DTO patterns and REST API design**.

The goal of this project was to practice building a **clean and structured backend architecture** using modern Java tools and frameworks commonly used in real-world backend systems.

---

# Tech Stack

This project uses the following technologies:

- Java 21
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Lombok
- MapStruct
- Swagger / OpenAPI
- Maven
- JUnit & Mockito (basic testing)

---

# Architecture

The application follows a **layered architecture** commonly used in Spring Boot applications.

Controller → Service → Repository → Database

Project structure:

```
controller
service
repository
model
dto
mapper
exception
```

### Layer responsibilities

**Controller**

Handles HTTP requests and responses.

**Service**

Contains the business logic of the application.

**Repository**

Responsible for database communication using Spring Data JPA.

**DTO**

Used to separate API input/output models from database entities.

**Mapper**

Converts DTOs into entities and vice versa using MapStruct.

---

# Domain Model

The application is composed of three main entities:

```
User
 └── Routes
      └── Locations
```

### Relationships

- A **User** can create multiple **Routes**
- A **Route** can contain multiple **Locations**

This structure allows users to build routes composed of several geographic points.

---

# API Endpoints

## Users

Create a user

POST /users

Retrieve all users

GET /users

---

## Routes

Create a route for a specific user

POST /routes?userId=1

Retrieve routes with pagination

GET /routes?page=0&size=10

---

## Locations

Create a location inside a route

POST /locations?routeId=1

Retrieve locations for a route

GET /locations/route/{routeId}

---

# API Documentation

Swagger documentation is available at:

http://localhost:8080/swagger-ui.html

Swagger provides an interactive interface to test and explore the API.

---

# Running the Project

### Clone the repository

```
git clone https://github.com/your-username/route-api.git
```

### Navigate to the project

```
cd route-api
```

### Run the application

```
mvn spring-boot:run
```

The API will start on:

http://localhost:8080

---

# Database

The project uses **H2 in-memory database** for development.

H2 Console:

http://localhost:8080/h2-console

JDBC URL:

```
jdbc:h2:mem:route_db
```

---

# Learning Objectives

This project was created to practice and better understand:

- Building REST APIs using Spring Boot
- Designing backend layered architecture
- Working with JPA/Hibernate entity relationships
- Implementing DTO patterns
- Using Lombok to reduce boilerplate code
- Using MapStruct for DTO ↔ Entity mapping
- API documentation with Swagger
- Validation and exception handling
- Basic backend unit testing

---

# Future Improvements

Possible improvements for this project include:

- Authentication and authorization (JWT)
- PostgreSQL database integration
- Docker containerization
- Integration tests
- Advanced search and filtering
- Route recommendation features

---

# Author

Software Engineering student exploring backend development with **Java and Spring Boot**.