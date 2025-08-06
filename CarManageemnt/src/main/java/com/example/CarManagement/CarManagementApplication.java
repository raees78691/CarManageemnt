package com.example.CarManagement;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log4j2
@SpringBootApplication
//@RestController
//@RequestMapping("/logs")

public class CarManagementApplication {



	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
		//logger.info("This is an info message slf4j.");
		log.info("Performing some operation.");
		log.error("An error occurred!", new RuntimeException("Example exception"));
		log.info("Performing some operation after Exception");
	}

}
