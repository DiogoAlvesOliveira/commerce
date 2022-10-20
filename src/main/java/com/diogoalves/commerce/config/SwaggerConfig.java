package com.diogoalves.commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private final ResponseMessage m201 = customMessage1();
    private final ResponseMessage m204put = simpleMessage(204, "Update ok");
    private final ResponseMessage m204del = simpleMessage(204, "Delete ok");
    private final ResponseMessage m404 = simpleMessage(404, "Not found");
    private final ResponseMessage m422 = simpleMessage(422, "Validation error");
    private final ResponseMessage m500 = simpleMessage(500, "Unexpected error");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, Arrays.asList(m404, m500))
                .globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m422, m500))
                .globalResponseMessage(RequestMethod.PUT, Arrays.asList(m204put, m404, m422, m500))
                .globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m204del, m404, m500))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diogoalves.commerce.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API Spring Boot",
                "Esta API foi desenvolvida por Diogo Alves",
                "Versão 1.0",
                "https://www.linkedin.com/in/diogo-alves-de-oliveira-217a75109/",
                new Contact("Diogo Alves de Oliveira", "https://github.com/DiogoAlvesOliveira/spring-boot-ionic-backend", "diogo.dream89@gmail.com"),
                "Sem restrições",
                "https://github.com/DiogoAlvesOliveira/spring-boot-ionic-backend",
                Collections.emptyList()
        );
    }

    private ResponseMessage simpleMessage(int code, String msg) {
        return new ResponseMessageBuilder().code(code).message(msg).build();
    }

    private ResponseMessage customMessage1() {
        Map<String, Header> map = new HashMap<>();
        map.put("location", new Header("location", "New resource URI", new ModelRef("string")));
        return new ResponseMessageBuilder()
                .code(201)
                .message("Resource created")
                .headersWithDescription(map)
                .build();
    }
}