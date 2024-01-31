package com.abhi.travelnotitificationmanager.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.travelnotificaionmanager.pojo.WeatherRequest;
import com.abhi.travelnotificationmanager.business.JelloIntegration;

@RestController
@RequestMapping("/clbk")
public class DemoController {
	
	@Autowired
	JelloIntegration integration;
	
	@GetMapping("/data")
    public ResponseEntity<Object> getData() {
		//JelloIntegration integration = new JelloIntegration();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        //integration.callWeatherChatBot();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
	
	@PostMapping("/jelloapichannel")
    public ResponseEntity<String> processWeatherRequest(@RequestBody WeatherRequest weatherRequest) {
		integration.callWeatherChatBot(weatherRequest);
        return ResponseEntity.ok("Weather request processed successfully");
    }


}
