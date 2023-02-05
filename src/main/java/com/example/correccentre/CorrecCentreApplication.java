package com.example.correccentre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CorrecCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrecCentreApplication.class, args);
	}

}
