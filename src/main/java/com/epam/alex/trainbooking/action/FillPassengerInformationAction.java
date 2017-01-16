package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class FillPassengerInformationAction implements Action {
    private static final String PASSENGER_INFORMATION_FORM = "passenger_information";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException {
        return PASSENGER_INFORMATION_FORM;
    }
}
