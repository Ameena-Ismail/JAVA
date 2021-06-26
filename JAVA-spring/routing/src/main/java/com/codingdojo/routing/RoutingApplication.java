package com.codingdojo.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication

@RestController
@RequestMapping("/coding")
public class RoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
	@RequestMapping("")
	public String CodingController() {
		return "Hello Coding Dojo";
	}
	@RequestMapping("/python")
	public String CodingController2() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String CodingController3() {
		return "Java/Spring is better!";
	}	
}