package com.example.permisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service" , "respository", "exception", "config"})
public class PermissonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermissonApplication.class, args);
	}

}
