package com.epam.alex.trainbooking.dao.jdbc;

import com.epam.alex.trainbooking.dao.*;
import com.epam.alex.trainbooking.exception.ConnectionPoolException;
import com.epam.alex.trainbooking.exception.JdbcDaoException;
import com.epam.alex.trainbooking.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory for producing necessary JdbcDao
 */
public class JdbcDaoFactory extends DaoFactory {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDaoFactory.class);
    private static final int TIMEOUT_CHECK_CONNECTION = 1;
    private static ConnectionPool pool;
    private Connection connection;

    public JdbcDaoFactory() throws JdbcDaoException {

        try {
            this.connection = pool.getConnection();

        } catch (ConnectionPoolException e) {
            throw new JdbcDaoException(e);
        }
    }

    /**
     * Set connection pool for this factory
     *
     * @param pool the pool with connections to database
     */
    public static void setPool(ConnectionPool pool) {
        JdbcDaoFactory.pool = pool;
    }

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao(connection);
    }

    /**
     * Opens transaction for database
     *
     * @throws JdbcDaoException on any SqlException
     * @see SQLException
     */
    @Override
    public void beginTx() throws JdbcDaoException {

        try {
            if ((!connection.isClosed()) && (connection.getAutoCommit())) {
                connection.setAutoCommit(false);
                logger.debug("Transaction open...");
            }
        } catch (SQLException e) {
            throw new JdbcDaoException(e);
        }
    }

    /**
     * Rollback transaction if any error during the process occurred
     *
     * @throws JdbcDaoException on any SqlException
     * @see SQLException
     */
    @Override
    public void rollback() throws JdbcDaoException {

        try {
            if ((!connection.isClosed()) && (!connection.getAutoCommit())) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.debug("Transaction rollback.");
            }
        } catch (SQLException e) {
            throw new JdbcDaoException(e);
        }
    }

    /**
     * Commit transaction in database
     *
     * @throws JdbcDaoException on any SqlException
     * @see SQLException
     */
    @Override
    public void commit() throws JdbcDaoException {

        try {
            if ((!connection.isClosed()) && (!connection.getAutoCommit())) {
                connection.commit();
                logger.debug("Transaction commit.");
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new JdbcDaoException(e);
        }
    }

    /**
     * Return connection back to pool
     *
     * @throws JdbcDaoException on any SqlException
     * @see SQLException
     */
    @Override
    public void close() throws JdbcDaoException {

        try {
            if (connection.isClosed() || !connection.isValid(TIMEOUT_CHECK_CONNECTION))
                logger.debug("Return connection is closed or invalid, and will not be add to the pool.");
            else
                pool.putConnectionToPool(connection);
        } catch (SQLException | ConnectionPoolException e) {
            throw new JdbcDaoException(e);
        }
    }
}
