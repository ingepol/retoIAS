package com.ias.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ias"})
@EnableJpaRepositories("com.ias.jpa")
@EntityScan("com.ias.domain")
public class RestApiIasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiIasApplication.class, args);
	}
}
