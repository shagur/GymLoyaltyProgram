package com.cs499;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan( basePackages = {"com.cs499.model"} )
public class group300ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(group300ProjectApplication.class, args);
	}

}
