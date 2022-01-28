package main.java.by.itoverone.exceeption;

public class CommandNotFoundException extends Exception{

    private String message;
    private String command;

    public CommandNotFoundException(String command) {
        this.message = "Command "+command+" not found";
    }
}
