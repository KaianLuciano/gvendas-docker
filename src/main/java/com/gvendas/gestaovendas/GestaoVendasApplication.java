package com.gvendas.gestaovendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gvendas.gestaovendas.model"})
@EnableJpaRepositories(basePackages = {"com.gvendas.gestaovendas.repository"})
@ComponentScan(basePackages = {"com.gvendas.gestaovendas.service", "com.gvendas.gestaovendas.controller", "com.gvendas.gestaovendas.exceptions"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}
	//http://localhost:8080/swagger-ui/index.html#/

}
