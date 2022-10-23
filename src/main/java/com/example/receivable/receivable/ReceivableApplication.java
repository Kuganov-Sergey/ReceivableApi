package com.example.receivable.receivable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.receivable.receivable")
@EnableJpaRepositories(basePackages = "com.example.receivable.receivable.DAO")
public class ReceivableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceivableApplication.class, args);
	}

}
