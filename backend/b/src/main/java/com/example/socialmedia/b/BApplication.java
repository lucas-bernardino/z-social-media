package com.example.socialmedia.b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BApplication {

	private static final Logger log = LoggerFactory.getLogger(BApplication.class);

	public static void main(String[] args) {
		log.info("Inicializando backend em Spring Boot ...");
		SpringApplication.run(BApplication.class, args);
	}

}