package main.java.by.itoverone.command;

public interface Command {
    public String execute(HttpServletRequest request) throws CommandExecutionException;

    String execute(HttpServletRequest request) throws CommandExecutionException;
}
