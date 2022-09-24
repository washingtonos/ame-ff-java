package com.fastforward.ameffjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket cardApi(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.fastforward.ameffjava"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaInfo());
  }

  private ApiInfo metaInfo() {
    return new ApiInfoBuilder()
        .title("Card API REST")
        .description("API REST para o FastFoward Ame 2022 #GirlPower")
        .contact(new Contact("Ame Digital", "amedigital.com.br", "amedigital@amedigital.com"))
        .build();
  }
}