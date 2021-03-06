package com.epam.alex.trainbooking.exception;

/**
 * Exception for wrapping any exceptions in Service layer
 */

public class ServiceException extends Exception {

    private String message;


    public ServiceException(String message, Exception e) {

        super(e);
        this.message = message;
    }

    public ServiceException(Exception e) {
        this.message = e.getMessage();
    }

    public ServiceException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
