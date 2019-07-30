package com.fun.docker.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

	@RequestMapping("/")
	public String hello() {
		return "Hello Docker";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
