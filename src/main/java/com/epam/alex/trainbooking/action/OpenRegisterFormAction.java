package com.epam.alex.trainbooking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenRegisterFormAction implements Action {

    private static final String REGISTER_JSP = "register";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return REGISTER_JSP;
    }
}
