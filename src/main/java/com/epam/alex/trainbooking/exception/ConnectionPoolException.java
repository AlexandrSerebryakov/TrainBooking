package com.epam.alex.trainbooking.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception for wrapping any exceptions in Connection pool.
 */

public class ConnectionPoolException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolException.class);


    public ConnectionPoolException(Exception e) {

        super(e);
        logger.error("An error with the database connection occurred", e);
    }

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }

    public ConnectionPoolException(String message) {

        super(message);

    }
}
