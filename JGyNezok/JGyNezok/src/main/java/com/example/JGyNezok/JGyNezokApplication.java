package com.example.JGyNezok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.JGyNezok")
@EntityScan(basePackages = "com.example.JGyNezok")
public class JGyNezokApplication {

	public static void main(String[] args) {
		SpringApplication.run(JGyNezokApplication.class, args);
	}

}
