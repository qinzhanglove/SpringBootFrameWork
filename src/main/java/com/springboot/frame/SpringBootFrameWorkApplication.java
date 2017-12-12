package com.springboot.frame;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableAdminServer
public class SpringBootFrameWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFrameWorkApplication.class, args);
	}
}
