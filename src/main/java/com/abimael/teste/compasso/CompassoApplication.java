package com.abimael.teste.compasso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.abimael.teste.compasso.model"})
@ComponentScan(basePackages = {"com.abimael.teste.compasso.rest"})
@EnableJpaRepositories("com.abimael.teste.compasso.repository")
public class CompassoApplication{

	public static void main(String[] args) {
		SpringApplication.run(CompassoApplication.class, args);
	}
}
