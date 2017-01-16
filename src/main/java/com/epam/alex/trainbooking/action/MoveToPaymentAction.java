package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class MoveToPaymentAction implements Action {
    private static final String PAYMENT_FORM = "payment";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException {
        return PAYMENT_FORM;
    }
}
