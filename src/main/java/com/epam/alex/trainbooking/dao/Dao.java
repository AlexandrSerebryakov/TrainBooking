package com.epam.alex.trainbooking.dao;

import com.epam.alex.trainbooking.exception.JdbcDaoException;
import com.epam.alex.trainbooking.model.BaseEntity;

import java.util.List;

/**
 * An universal interface for DAO objects operations.
 */
public interface Dao<T extends BaseEntity> {

    //Operation for save entity
    T save(T entity, List<Object> parameters, String key) throws JdbcDaoException;

    //Operation for update entity
    T update(T entity, List<Object> parameters, String key) throws JdbcDaoException;

    //Operation for find entity
    List<T> findByParameters(T entity, List<Object> parameters, String key, String locale) throws JdbcDaoException;

}