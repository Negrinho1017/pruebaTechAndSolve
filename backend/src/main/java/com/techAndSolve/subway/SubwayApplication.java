package com.techAndSolve.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SubwayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SubwayApplication.class, args);
	}
}
