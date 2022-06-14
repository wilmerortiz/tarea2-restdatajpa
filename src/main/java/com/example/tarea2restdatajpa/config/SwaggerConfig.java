package com.example.tarea2restdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 *  Configuración de Swagger para la generación de documentación de la API REST
 *
 *  http://localhost:9000/swagger-ui/
 */

@Configuration
public class SwaggerConfig {
  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiDetails())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiDetails(){
    return new ApiInfo(
        "Spring Boot REST API",
        "Spring Boot REST API for Online Store",
        "1.0",
        "http://amocdigital.com",
        new Contact("Wilmer", "http://amocdigital.com", "wilmer@gmail.com"),
        "Api License Version 1.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        Collections.emptyList()
    );
  }
}
