package com.example.javeedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JaveedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaveedemoApplication.class, args);
	}
	@GetMapping
	public String health(){
		return "success";
	}
}
