package com.ekrea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//import com.ekrea.config.MyApplicationEnvironmentPreparedEventListener;
//import com.ekrea.config.MyApplicationStartedEventListener;

@SpringBootApplication
//@EnableScheduling
public class AkreaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AkreaApplication.class);
//		app.addListeners(new MyApplicationStartedEventListener());
//		app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
		app.run(args);
	}
}
