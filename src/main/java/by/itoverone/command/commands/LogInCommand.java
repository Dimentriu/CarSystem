package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;
import main.java.by.itoverone.entity.User;

import java.util.logging.Logger;

public class LogInCommand implements Command {
    static Logger logger = LoggerFactory.getLogger(LogInCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        String ret = "/pages/login.jsp";
        logger.info("login request!");
        Object request_name = request.getParameter("login_name");
        Object request_pass = request.getParameter("login_password");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        if ((request_name != null) && (request_pass != null)) {


            logger.info("login : " + request_name + " pass: " + request_pass);

            User user = serviceFactory.getUserService().logIn((String) request_name, (String) request_pass);

            if (user != null) {
                request.setAttribute("login_status", "success");
                request.getSession().setAttribute("logged_USER", user);
                ret = "/pages/index.jsp";
            } else {
                request.setAttribute("login_status", "fail");
            }

        } else {
            request.setAttribute("login_status", "new");
        }

        return ret;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return null;
    }
}