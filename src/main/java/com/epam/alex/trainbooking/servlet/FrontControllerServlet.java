package com.epam.alex.trainbooking.servlet;

import com.epam.alex.trainbooking.action.Action;
import com.epam.alex.trainbooking.action.ActionFactory;
import com.epam.alex.trainbooking.exception.ActionException;
import com.epam.alex.trainbooking.exception.ActionFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */

@WebServlet(name = "FrontControllerServlet", urlPatterns = "/do/*")
@MultipartConfig

public class FrontControllerServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FrontControllerServlet.class);

    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String ACTION_PREFIX = "action";
    private static final String PATH_TO_JSP = "/WEB-INF/jsp/";
    private static final String PATH_TO_EPAM = "https://www.epam.kz/";
    private static final String FILE_JSP = ".jsp";
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {

        actionFactory = new ActionFactory();
        try {
            actionFactory.loadActions();
        } catch (ActionFactoryException e) {
            logger.error("Action Factory error in controller occurred", e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String actionName = getActionName(req);
        try {
            Action action = actionFactory.getAction(actionName);
            logger.debug("Received {} request with command: \"{}\", get action: {}", req.getMethod(), actionName, action.getClass().getSimpleName());
            String view = action.execute(req, resp);
            proceedTo(view, req, resp);
        } catch (ActionException | ActionFactoryException e) {
            logger.error("Exception in controller occurred", e);
        }
    }



    private void proceedTo(String view, HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {

            req.getRequestDispatcher(PATH_TO_JSP + view + FILE_JSP).forward(req, resp);
        }



    private String getActionName(HttpServletRequest req) {
        return req.getParameter(ACTION_PREFIX);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
