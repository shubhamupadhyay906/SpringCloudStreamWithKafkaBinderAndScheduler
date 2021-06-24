package com.mindtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableScheduling
@EnableBinding(Source.class)
public class PublisherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherServiceApplication.class, args);
	}

}
