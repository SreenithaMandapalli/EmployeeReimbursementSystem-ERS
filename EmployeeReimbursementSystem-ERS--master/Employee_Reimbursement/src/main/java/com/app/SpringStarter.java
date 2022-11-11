package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStarter {

	static  Logger log = LoggerFactory.getLogger(SpringStarter.class);
	public static void main(String[] args) {

		log.debug("SpringStarter application started ....");
		SpringApplication.run(SpringStarter.class, args);
		
	}

}

