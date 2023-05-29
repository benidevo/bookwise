# BookWise API - Library Management System

BookWise API is a web-based Library Management System implementation built with Spring Boot, providing a robust solution for efficiently managing books, borrowers, and loans in a library setting.

## Features

- Book Management: Add, retrieve, update, and delete books with details such as title, author, ISBN, and publication date.
- Borrower Management: Manage borrowers' information including name, email, and address.
- Loan Management: Create, update, and retrieve loans, associating books with borrowers, and tracking loan activities.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL (or any preferred database)
- Maven (for dependency management)
- RESTful API principles

## Getting Started

### Prerequisites

- Java 11 or above
- MySQL (or any preferred database) installed and running

### Installation

1. Clone the repository:

```shell
git clone https://github.com/benidevo/bookwise-api.git
```

2.  Configure the database connection in the application.properties file:

```agsl
spring.datasource.url=jdbc:mysql://localhost:3306/bookwise
spring.datasource.username=your-username
spring.datasource.password=your-password
```

3. Run the application:

```shell
mvn spring-boot:run
```