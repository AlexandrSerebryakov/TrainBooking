package com.epam.alex.trainbooking.exception;

/**
 * Exception for wrapping any exceptions in LocaleChanger
 */

public class LocaleChangerException extends Exception {

    public LocaleChangerException(ServiceException e) {
        super(e);
    }
}
