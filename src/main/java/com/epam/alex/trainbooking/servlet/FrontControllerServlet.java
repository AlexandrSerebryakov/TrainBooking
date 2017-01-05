package com.epam.alex.trainbooking.servlet;

import com.epam.alex.trainbooking.action.Action;
import com.epam.alex.trainbooking.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
/*
@WebServlet(name = "FrontControllerServlet", urlPatterns = "/do*/
/*")
*/
/*
@MultipartConfig
*/

public class FrontControllerServlet extends HttpServlet {

    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String ACTION_PREFIX = "action";
    private static final String PATH_TO_JSP = "/WEB-INF/jsp/";
    private static final String FILE_JSP = ".jsp";
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {

        actionFactory = new ActionFactory();
        try {
            actionFactory.loadActions();

        } catch (IOException e) {
            // TODO change IOExc to ActionExc
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        String actionName = getActionName(req);
        try {
            Action action = actionFactory.getAction(actionName);
            String view = action.execute(req, resp);
            proceedTo(view, req, resp);

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void proceedTo(String view, HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {

        /*if (view.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
        } else {
        */    req.getRequestDispatcher(PATH_TO_JSP + view + FILE_JSP).forward(req, resp);


        /*}*/
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
