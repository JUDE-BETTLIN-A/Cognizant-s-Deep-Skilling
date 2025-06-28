package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message: Application started");
        logger.info("Info message: Running multi-appender logging example");
        logger.warn("Warning message: This is a sample warning");
        logger.error("Error message: This is a sample error");
    }
}
