package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;

public class GoHomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return "/pages/index.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return null;
    }
}