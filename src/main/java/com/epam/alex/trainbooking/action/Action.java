package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public interface Action {
    String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException;

}
