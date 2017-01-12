package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class RegistrationAction implements Action {

    private static final String INDEX_JSP = "index";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException {
        return INDEX_JSP;
    }
}
