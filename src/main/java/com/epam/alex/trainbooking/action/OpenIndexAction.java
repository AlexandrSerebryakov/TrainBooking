package com.epam.alex.trainbooking.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenIndexAction implements Action {

    private static final String INDEX_JSP = "index";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        return INDEX_JSP;
    }
}
