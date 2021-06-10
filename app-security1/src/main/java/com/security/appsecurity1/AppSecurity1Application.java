package com.security.appsecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppSecurity1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppSecurity1Application.class, args);
	}

}
