package com.manager.ApartmentManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableJpaRepositories("com.manager.repository")
@ComponentScan(basePackages = "com.manager.controller")
@ComponentScan(basePackages = "com.manager.ApartmentManager")
@ComponentScan(basePackages = "com.manager.security")
@EntityScan("com.manager.entity")
@EnableSwagger2
public class ApartmentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentManagerApplication.class, args);
	}

}
