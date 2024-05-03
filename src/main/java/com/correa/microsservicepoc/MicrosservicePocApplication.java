package com.correa.microsservicepoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MicrosservicePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosservicePocApplication.class, args);
	}

}
