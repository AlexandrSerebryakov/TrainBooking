package com.epam.alex.trainbooking.exception;


/**
 * Exception for wrapping any exceptions in Action layer
 */

public class ActionException extends Exception {

    public ActionException(Exception e) {
        super(e);
    }
}
