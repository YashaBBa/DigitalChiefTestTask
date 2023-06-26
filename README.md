# Digital Chief - University Management System

Digital Chief is a University Management System that helps manage universities, faculties, and specialities within an educational institution. It provides functionalities to store and retrieve information about universities, faculties, and specialities.

## Domain Model

The domain model consists of the following entities:

### University

- `id` (int, primary key): The unique identifier for the university.
- `name` (varchar): The name of the university.
- `city` (varchar): The city where the university is located.
- `country` (varchar): The country where the university is located.
- `founding_date` (date): The founding date of the university.
- `number_of_students` (int): The total number of students in the university.

### Faculty

- `id` (int, primary key): The unique identifier for the faculty.
- `name` (varchar): The name of the faculty.
- `dean_name` (varchar): The name of the dean of the faculty.
- `founding_date` (date): The founding date of the faculty.
- `min_score` (int): The minimum score required for admission to the faculty.
- `count_of_students` (int): The total number of students in the faculty.
- `univers_id` (int, foreign key): The university to which the faculty belongs.

### Speciality

- `id` (int, primary key): The unique identifier for the speciality.
- `name` (varchar): The name of the speciality.
- `degree_level` (varchar): The level of degree offered by the speciality.
- `founding_date` (date): The founding date of the speciality.
- `min_score` (int): The minimum score required for admission to the speciality.
- `count_of_students` (int): The total number of students in the speciality.
- `faculties_id` (int, foreign key): The faculty to which the speciality belongs.

## Composition

The composition in the Digital Chief system is as follows:

- Each university can have multiple faculties. The `univers_id` foreign key in the `faculty` table references the `id` column of the `university` table.
- Each faculty can have multiple specialities. The `faculties_id` foreign key in the `speciality` table references the `id` column of the `faculty` table.

## Usage

To use the Digital Chief system, you can perform CRUD operations on the university, faculty, and speciality entities through the provided APIs. The system allows you to create, retrieve, update, and delete records for universities, faculties, and specialities.

## Getting Started

To get started with this project, follow the steps below:

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Download all project dependencies in the pom.xml file.
4. Configure the database connection in the application properties file (`src/main/resources/application.properties`).
5. Build and run the application.
6. Access the application through the provided endpoints and web interfaces.

## Additional Information

Here are some additional details about the project dependencies:

- **spring-boot-starter-web**: This starter provides the necessary dependencies for building web applications using Spring MVC. It includes the embedded Tomcat server and other components required for web development.

- **spring-boot-starter-thymeleaf**: Thymeleaf is a popular templating engine for server-side rendering in Spring MVC applications. This starter includes Thymeleaf and its dependencies, allowing you to use Thymeleaf templates in your web application.

- **flyway-mysql**: Flyway is a database migration tool that helps manage database schema changes over time. This dependency specifically adds support for MySQL databases in Flyway.

- **lombok**: Lombok is a library that helps reduce boilerplate code in Java classes. It automatically generates getter, setter, and other common methods at compile-time, making your code more concise and readable.

- **mysql-connector-java**: This is the JDBC driver for MySQL databases. It enables your Java application to connect to a MySQL database server and perform database operations.

- **spring-boot-starter-test**: This starter provides dependencies for testing Spring Boot applications. It includes frameworks and libraries like JUnit, Mockito, and Spring Test for writing unit tests and integration tests.

- **spring-boot-starter-validation**: This starter includes the necessary dependencies for using JSR 380 Bean Validation API in Spring applications. It enables you to validate input data and enforce business rules using annotations and validation constraints.

- **hibernate-validator**: Hibernate Validator is the reference implementation of the JSR 380 Bean Validation API. It provides additional validation capabilities beyond the standard API and integrates seamlessly with Spring Boot.

- **spring-data-jpa**: This dependency is part of the Spring Data project and simplifies the implementation of JPA repositories. It provides a high-level abstraction for working with databases using the Java Persistence API (JPA).

- **spring-boot-starter-data-jpa**: This starter combines the dependencies required for using Spring Data JPA with Hibernate as the JPA provider. It includes the necessary libraries for database access, entity management, and transaction management.

- **annotations**: The JetBrains annotations library provides additional annotations for code analysis and documentation purposes. These annotations can be used to improve code quality, enforce contracts, and generate documentation.


