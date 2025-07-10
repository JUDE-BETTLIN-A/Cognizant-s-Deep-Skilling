package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application STARTING...");
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application STARTED successfully.");

		SpringLearnApplication app = new SpringLearnApplication();
		app.displayDate();
	}

	public void displayDate() {
		LOGGER.info("START");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());
		LOGGER.debug(date);
		LOGGER.info("END");
	}
}
