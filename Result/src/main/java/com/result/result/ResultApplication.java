package com.result.result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultApplication.class, args);
	}

}
