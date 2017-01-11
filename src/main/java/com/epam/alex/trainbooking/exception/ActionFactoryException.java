package com.epam.alex.trainbooking.exception;

/**
 * Exception for wrapping any exceptions in Action factory
 */

public class ActionFactoryException extends Exception {

    public ActionFactoryException(Exception e) {

        super(e);
    }
}
