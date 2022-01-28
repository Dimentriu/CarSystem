package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;
import main.java.by.itoverone.entity.User;

import java.util.logging.Logger;

public class RegisterCommand implements Command {
    static Logger logger = LoggerFactory.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        logger.info("register command execution started");
        Object request_name = request.getParameter("register_name");
        Object request_pass = request.getParameter("register_password");
        Object request_role = request.getParameter("register_role");
        if ((request_name != null) && (request_pass != null)) {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            logger.info("got instance");


            if (serviceFactory.getUserService().register((String) request_name, (String) request_pass, User.Role.values()[Integer.parseInt((String) request_role)])) {
                logger.info("Success");
                request.setAttribute("register_status", "success");
            } else {
                logger.info("fail");
                request.setAttribute("register_status", "fail");
            }
        } else {
            logger.info("new");
            request.setAttribute("register_status", "new");
        }
        
        return "/pages/register.jsp";
    }
}