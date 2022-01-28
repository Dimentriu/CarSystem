package main.java.by.itoverone.command;

import main.java.by.itoverone.exceeption.CommandNotFoundException;

public interface CommandFactory {
    public Command getCommand(String commandName) throws CommandNotFoundException;
}