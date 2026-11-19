# Employee Management System

A web-based Employee Management System developed using Java, JSP, Servlets, JDBC, and MySQL to manage employee records efficiently.

## Technologies Used
- Java
- JSP (JavaServer Pages)
- Servlets
- JDBC
- MySQL
- Apache Tomcat
- Maven
- Eclipse IDE

## Employee Details
The Employee entity contains:
- Employee ID
- Name
- Age
- Department
- Salary
- Email

## Project Structure
The application follows a layered architecture:

- **Model:** Contains Employee entity and database connection.
- **Service:** Handles business logic and JDBC operations.
- **Controller:** Manages HTTP requests and connects JSP pages with the Service layer.
- **JSP:** Provides the user interface.

## Features
- Register new employees.
- View all employee records.
- Update employee details.
- Delete employee records.
- Search employees by department.
- Store and retrieve employee information using MySQL.

## Application Flow
JSP → Controller → Service → Model / Database Connection → MySQL

## Database
MySQL is used to store employee information. JDBC is used to establish database connectivity and execute SQL queries.

## Server
Apache Tomcat is used to deploy and run the web application.

## Author
**Jenica Judith**

Java | JSP | JDBC | MySQL | Spring Boot

*Developed as part of my Java Full Stack Development practice.*
