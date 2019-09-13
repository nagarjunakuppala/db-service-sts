package org.uhcl.edu.stock.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "org.uhcl.edu.stock.dbservice.repository")
@EnableAutoConfiguration
@SpringBootApplication
public class DBServiceApp {

	public static void main(String[] args) {

		SpringApplication.run(DBServiceApp.class, args);
	}

}
