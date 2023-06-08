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

##### 6. Build Create Todo REST API
- TodoService - serve as todo interface, so every behavior we set for todo service is serve as rules in todo implementation
- TodoServiceImpl - serve as todo service implementation class that override the rules we set in TodoService(createTodo)
- TodoController - serve as REST API for todo, we only implement the @PostMapping for the creation of todo

##### 7. Use modelMapper dependency to map the todoJpa to todoDto or vice versa
- First, add the modelMapper dependency to pom.xml file
- Second, Create bean for modelMapper
- Third, use modelMapper.map method

##### 8. Get Todo by Id REST API
- Create getTodoById() method in TodoService Interface
- Implement the getTodoById() method in the implementation
- Create exception if todo is not exist
- In the getTodoById() method store todoJpa result to todoDto orElseThrow the resourceNotfFoundException

##### 9. Get All Todos REST API
- Create getAllTodos() method in TodoService Interface
- Implement the getTodoById() method in the implementation
- In the getAllTodos() method, the todoJpa result map into todoDt

##### 10. Update Todo REST API
- Create updateTodo(TodoDto var, Long id) method in TodoService Interface
- Implement the updateTodo(TodoDto var, LongId) method in the implementation
- In the getAllTodos(TodoDto var, Long id) method, get the todo information using findById method, pass the id variable and store in todo variable
- Set the updated value of todo information and save it
- Return the map todo jpa to todoDto

##### 11. Delete Todo REST API
- Create deleteById(Long id) method in TodoService Interface
- Implement the updateTodo(LongId) method in the implementation
- Check if the supplied id exist, if not return exception else delete the todo with that id
- Use that method in Delete REST API and return String message

##### 12. PATCH REST API to update the todo partially (set todo as incomplete)
- Create completedTodo(Long id) method in TodoService Interface
- Implement the completedTodo(LongId) method in the implementation
- Check if the supplied id exist, if not return exception else patch update the column isCompleted to true
- Use that method in PATCH REST API and return todoDTO


## 👨‍💻Contact Me 🚀🔵
- Email - jesther.jc15@gmail.com
- LinkedIn - https://www.linkedin.com/in/jesther-costinar/
- Facebook - https://www.facebook.com/jeestheeer
- Instagram - https://www.instagram.com/kaassmir/
- Twitter - https://twitter.com/kasmir_
