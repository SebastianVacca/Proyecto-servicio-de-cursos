package com.devsenior.svacca.courses_service.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class openApiConfiguration {

    @Bean
   OpenAPI openApi(){
    return new OpenAPI()
        .info(new Info()
            .title("API de gestión de cursos académicos")
            .description("Sistema completo de gestión de cursos pra la universidad virtual")
            .version("v1.0")
        .contact(new Contact()
            .name("Juan Vacca")
            .email("clanbs11.12@gmail.com")
            .url("http://paginaWeb.com"))
        .license(new License()
            .name("MIT License")
            .url("https://opensource.org/license/MIT")))
        .servers(List.of(
            new Server().url("http://localhost:8080").description("Entorno de desarrollo"),
            new Server().url("https://api.cursos.devsenior.com").description("Entorno de producción")
    ));
   }

}
