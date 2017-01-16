package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class ReceiveTicketAction implements Action {
    private static final String TICKET_FORM = "ticket";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException {
        return TICKET_FORM;
    }
}
