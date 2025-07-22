package com.example.cricket_zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class CricketZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketZoneApplication.class, args);
	}

}
