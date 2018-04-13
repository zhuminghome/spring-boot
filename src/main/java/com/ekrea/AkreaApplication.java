package com.ekrea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class AkreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkreaApplication.class, args);
	}
}
