package com.epam.alex.trainbooking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class OpenLoginFormAction implements Action {
    private static final String LOGIN_FORM = "login";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return LOGIN_FORM;
    }
}
