package com.epam.alex.trainbooking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class RussianLocaleAction implements Action {
    private static final String LOCALE = "ru";
    private static final String LOCALE_ATTR_NAME = "locale";
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.getSession(false).setAttribute(LOCALE_ATTR_NAME, LOCALE);
        String referrer = req.getHeader("referer");

        return REDIRECT_PREFIX + referrer;
    }
}
