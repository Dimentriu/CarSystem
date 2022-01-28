package main.java.by.itoverone.command;

import main.java.by.itoverone.command.commands.*;
import main.java.by.itoverone.exceeption.CommandNotFoundException;

import java.util.HashMap;
import java.util.logging.Logger;

public class CommandFactoryImpl implements CommandFactory {
    static Logger logger = LoggerFactory.getLogger(CommandFactory.class);
    private static CommandFactory instance;
    private HashMap<String, Command> commands;

    public CommandFactoryImpl() {
        commands = new HashMap<>();
        //todo:load all comands from comands folder
        commands.put("login_cmd", (Command) new LogInCommand());
        commands.put("about_cmd", (Command) new ShowInfoCommand());
        commands.put("order_cmd", (Command) new MakeOrderCommand());
        commands.put("home_cmd", (Command) new GoHomeCommand());
        commands.put("register_cmd", (Command) new RegisterCommand());
        commands.put("logout_cmd", (Command) new LogOutCommand());
        commands.put("distribute_cmd", (Command) new DistributeOrdersCommand());
        commands.put("lang_cmd", (Command) new ChangeLocaleCommand());
    }

    private Object ommand() {
        return null;
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactoryImpl();
        }
        return instance;
    }

    @Override
    public Command getCommand(String commandName) throws CommandNotFoundException {
        System.out.println("commandName");
        if (commands.containsKey(commandName)) {
            System.out.println("contains");
            return commands.get(commandName);
        } else {
            System.out.println("throwing");
            throw (new CommandNotFoundException(commandName));
        }
    }
}