<h1 style="color: #FF0000;" align="center">TODO MANAGEMENT SYSTEM</h1>
<h6 style="color: #FF0000;" align="center"><a href="http://localhost:8080/swagger-ui/index.html#/">REST API Documentation</a></h6>


## 💾 Technologies & Framework

Programming Languages and Framework:

- <strong>Java</strong> is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.
- <strong>Spring Boot</strong> A widely used and popular spring framework used for building enterprise application
- <strong>Spring MVC</strong> A very popular web framework of spring core that used model-view-controller pattern.
- <strong>Spring Security</strong> A very popular web framework that provides authentication, authorization and other security features for enterprise applications.
- <strong>Spring Data JPA (Hibernate)</strong> provides a simplified and efficient way to work with relational databases using the Java Persistence API (JPA)
- <strong>MySQL</strong> is a relational database management system. Databases are the essential data repository for all software applications.

## 🔵 Process for creating the project
##### 1. Create and Setup Springboot project here: <a href="https://start.spring.io/">( link )</a>. Now, add the following dependencies:

- Spring Web
- Lombok
- Spring Data JPA
- MySQL Driver

##### 2. Setup the database oonnection in application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
spring.datasource.username={db_root}
spring.datasource.password={db_password}

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
##### 3. Create the following package/folder structure:

- <strong>controller</strong> - is responsible for handling the incoming request and send back the response match to the url
- <strong>dto</strong> - is responsible for mapping the jpa data to dto or vice versa. this is to limit the data access of the client and perform encapsulation.
- <strong>entity</strong> - or model is responsible for creation of table and columns. The jpa maps the entity class to its corresponding table.
- <strong>repository</strong> - is responsible for the database operations such as insert query, update, select and delete. repository extend the JpaRepository to use the crud operation of the entity
- <strong>service</strong> - or the business logic in the application. Its responsible for creation of business rules such as fields validation, handling exception, etc..
- <strong>utils</strong> - or utility class is responsible for reusable codes that can access across the application

##### 4. Create Todo entity/model
- The todo class will serve as the table, and by the help of JPA, it maps the entity class to the corresponding table

##### 5. Create the Todo Repository and TodoDto
- Todo Repository extends the JPA repository and supply the Todo entity so that, we can now have access to database operations for todo entity.
- Todo Dto - to limit the client access from todo data.

## 👨‍💻Contact Me 🚀🔵
- Email - jesther.jc15@gmail.com
- LinkedIn - https://www.linkedin.com/in/jesther-costinar/
- Facebook - https://www.facebook.com/jeestheeer
- Instagram - https://www.instagram.com/kaassmir/
- Twitter - https://twitter.com/kasmir_
