package com.fastforward.ameffjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
public class AmeFfJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmeFfJavaApplication.class, args);
	}

}