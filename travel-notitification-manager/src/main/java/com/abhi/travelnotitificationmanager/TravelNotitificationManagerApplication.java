package com.abhi.travelnotitificationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = {"com.abhi.travelnotificationmanager.business"})
public class TravelNotitificationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelNotitificationManagerApplication.class, args);
	}

	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
}
