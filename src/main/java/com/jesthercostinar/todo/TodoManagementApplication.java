package com.jesthercostinar.todo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Todo Management REST API Documentation",
				description = "List of REST API in Todo Management System",
				version = "v1.1",
				contact = @Contact(
						name = "Jesther Costinar",
						email = "jesther.jc15@gmail.com",
						url = "https://jesthercostinar-todo.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://jesthercostinar-todo.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Todo Management Documentation",
				url = "https://jesthercostinar-todo.com/documentation.pdf"
		)
)
@SpringBootApplication
public class TodoManagementApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
