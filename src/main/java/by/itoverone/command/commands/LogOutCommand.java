package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;

import java.util.logging.Logger;

public class LogOutCommand implements Command {
    static Logger logger = LoggerFactory.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        String ret = "/pages/index.jsp";
        logger.info("logOut request!");
        request.getSession().setAttribute("logged_USER", null);

        return ret;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return null;
    }
}