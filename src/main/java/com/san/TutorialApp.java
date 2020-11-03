package com.san;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com"})
@EnableJpaRepositories(basePackages = {"com"})
@ComponentScan(basePackages = {"com"})
@EnableAutoConfiguration
public class TutorialApp {

	public static void main(String[] args) {
		System.out.print("started 1");
		SpringApplication.run(TutorialApp.class, args);
		System.out.print("started 2");
	}

}
