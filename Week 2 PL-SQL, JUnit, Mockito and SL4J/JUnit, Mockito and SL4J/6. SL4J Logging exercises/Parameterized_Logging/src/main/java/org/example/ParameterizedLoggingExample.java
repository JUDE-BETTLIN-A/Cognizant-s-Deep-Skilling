package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "jude";
        int loginAttempts = 3;

        logger.info("User {} has logged in {} times", username, loginAttempts);

        double amount = 199.99;
        String product = "Headphones";

        logger.warn("Payment of ${} for {} is pending confirmation", amount, product);
    }
}
