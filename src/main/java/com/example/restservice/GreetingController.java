package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Good Evening, %s!";
	private final AtomicLong counter = new AtomicLong();

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GreetingController.class);	

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		int cnt = (int) counter.incrementAndGet();
		
		LOGGER.info("--[/greeting] id : " + cnt + ", name: " + name + " ---");
		return new Greeting(cnt, String.format(template, name));
	}
}
