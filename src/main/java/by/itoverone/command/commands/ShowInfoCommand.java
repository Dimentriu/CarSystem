package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;
import main.java.by.itoverone.entity.CarPurpose;

import java.util.logging.Logger;

public class ShowInfoCommand Command {
    static Logger logger = LoggerFactory.getLogger(ShowInfoCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        logger.info("showinfo request!");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        logger.info("got instance");
        CarPurpose purpose = serviceFactory.getTruckService().getCarPurposeById(1);
        CarPurpose[] purposes = serviceFactory.getTruckService().getAllCarPurposes();
        logger.info("got purpose");
        request.setAttribute("carPurpose1", purpose);
        request.setAttribute("carPurposes", purposes);
        logger.info("returning");
        return "/pages/about.jsp";
    }
}