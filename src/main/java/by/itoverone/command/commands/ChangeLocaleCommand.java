package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;

import java.util.Locale;
import java.util.logging.Logger;

public class ChangeLocaleCommand implements Command {
    static Logger logger = LoggerFactory.getLogger(DistributeOrdersCommand.class);

    private final static Locale locale1 = new Locale("ru", "RU");
    private final static Locale locale2 = new Locale("en", "US");

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        logger.info("lang_cmd executed");

        if (request.getSession().getAttribute("locale") == locale1) {
            logger.info("if");
            request.getSession().setAttribute("locale", locale2);
        } else {
            logger.info("else");
            request.getSession().setAttribute("locale", locale1);
        }

        return "/pages/index.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return null;
    }
}