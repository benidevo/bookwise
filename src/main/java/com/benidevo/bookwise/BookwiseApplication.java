package com.benidevo.bookwise;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "BookWise API - Library Management System",
				description = "BookWise API is a web-based Library Management System " +
						"implementation built with Spring Boot, providing a robust solution for efficiently managing " +
						"books, borrowers, and loans in a library setting.",
				version = "v1.0",
				contact = @Contact(
						name = "Benjamin Idewor",
						email = "benjaminidewor@gmail.com",
						url = "https://github.com/benidevo"
				),
				license = @License(
						name = "MIT",
						url = "https://opensource.org/license/mit/"
				)
		)
)
public class BookwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookwiseApplication.class, args);
	}

}
