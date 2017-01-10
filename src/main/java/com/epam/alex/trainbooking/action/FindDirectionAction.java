package com.epam.alex.trainbooking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class FindDirectionAction implements Action {
    private static final String TRAIN_SCHEDULE_FORM = "train_schedule";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return TRAIN_SCHEDULE_FORM;
    }
}
