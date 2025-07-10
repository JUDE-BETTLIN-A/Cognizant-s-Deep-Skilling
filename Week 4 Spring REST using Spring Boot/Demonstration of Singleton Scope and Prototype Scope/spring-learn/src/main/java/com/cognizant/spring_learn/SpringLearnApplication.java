package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application STARTING...");

		displayCountryScopes();

		LOGGER.info("Application ENDED.");
	}

	public static void displayCountryScopes() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		// Singleton
		Country singleton1 = context.getBean("countrySingleton", Country.class);
		Country singleton2 = context.getBean("countrySingleton", Country.class);
		LOGGER.debug("Singleton Country 1: {}", singleton1);
		LOGGER.debug("Singleton Country 2: {}", singleton2);
		LOGGER.debug("Are singleton references equal? {}", singleton1 == singleton2);

		// Prototype
		Country prototype1 = context.getBean("countryPrototype", Country.class);
		Country prototype2 = context.getBean("countryPrototype", Country.class);
		LOGGER.debug("Prototype Country 1: {}", prototype1);
		LOGGER.debug("Prototype Country 2: {}", prototype2);
		LOGGER.debug("Are prototype references equal? {}", prototype1 == prototype2);

		LOGGER.info("END");
	}
}
