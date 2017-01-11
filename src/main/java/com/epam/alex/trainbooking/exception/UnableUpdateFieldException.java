package com.epam.alex.trainbooking.exception;

/**
 * General exception, throws if field update ends without result.
 */

public class UnableUpdateFieldException extends JdbcDaoException {

    public UnableUpdateFieldException() {

        super();
    }
}
