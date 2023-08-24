package com.roshan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class UserManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("User Management Api Created By Roshan")
	              .description("User Management Api")
	              .version("v1.0.0")
	              .license(new License().name("Source Code").url("https://github.com/roshanrazz/user-management-api")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Contact me here")
	              .url("https://www.linkedin.com/in/roshansah/"));
	  }

}
