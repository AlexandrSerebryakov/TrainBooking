package com.epam.alex.trainbooking.dao;

import com.epam.alex.trainbooking.dao.jdbc.JdbcDaoFactory;
import com.epam.alex.trainbooking.exception.DaoException;
import com.epam.alex.trainbooking.exception.JdbcDaoException;

/**
 * Abstract factory for producing others factories.
 */

public abstract class DaoFactory implements AutoCloseable {

    /**
     * Produce Jdbc factory
     *
     * @return Jdbc factory
     * @throws DaoException parent exception for any exceptions from factories
     */
    public static DaoFactory createJdbcFactory() throws DaoException {
        try {
            return new JdbcDaoFactory();
        } catch (JdbcDaoException e) {
            throw new DaoException(e);
        }
    }

    public abstract UserDao getUserDao();

    public abstract void beginTx() throws JdbcDaoException;

    public abstract void rollback() throws JdbcDaoException;

    public abstract void commit() throws JdbcDaoException;

    @Override
    public void close() throws JdbcDaoException {

    }
}