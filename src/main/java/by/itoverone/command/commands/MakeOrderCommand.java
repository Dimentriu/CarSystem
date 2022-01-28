package main.java.by.itoverone.command.commands;

import main.java.by.itoverone.command.Command;
import main.java.by.itoverone.command.CommandExecutionException;
import main.java.by.itoverone.command.HttpServletRequest;
import main.java.by.itoverone.command.LoggerFactory;
import main.java.by.itoverone.entity.Order;
import main.java.by.itoverone.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MakeOrderCommand implements Command {
    static Logger logger = LoggerFactory.getLogger(MakeOrderCommand.class);

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final String NEXT_PAGE_URI = "WEB-INF/jsp/test.jsp";
    private static final String FINISH_TEST_PAGE_URI = "WEB-INF/jsp/finishTest.jsp";

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        User user = null;
        if (request.getSession().getAttribute("logged_USER") != null) {
            user = (User) request.getSession().getAttribute("logged_USER");
        }

        logger.info("placeOrderCommand called from " + request.getSession().getAttribute("logged_USER"));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        String ret = "/pages/order.jsp";
        Object requestStatus = request.getParameter("order_status");

        if (requestStatus != null) {

            logger.info("requestStatus = " + (String) requestStatus);
            if (0 == ((String) requestStatus).compareTo("filled")) {

                logger.info("filled:");

                // User user= (User) request.getSession().getAttribute("logged_USER");
                logger.info("user = " + user);
                float size = Float.parseFloat(request.getParameter("order_size"));
                logger.info("size = " + size);
                float volume = Float.parseFloat(request.getParameter("order_volume"));
                logger.info("volume = " + volume);
                float weight = Float.parseFloat(request.getParameter("order_weight"));
                logger.info("weight = " + weight);
                Date shipmentDate = null;
                Date destinationDate = null;
                try {
                    shipmentDate = sdf.parse(request.getParameter("order_shipmentDate"));
                    logger.info("shipmentDate = " + shipmentDate);
                    destinationDate = sdf.parse(request.getParameter("order_destinationDate"));
                    logger.info("destinationDate = " + destinationDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String shipmentpoint = request.getParameter("order_shipmentPoint");
                logger.info("shipmentpoint = " + shipmentpoint);
                String destinationpoint = request.getParameter("order_destinationPoint");
                logger.info("destinationpoint = " + destinationpoint);
                logger.info("addingOrder");

                serviceFactory.getOrderService().addOrder(
                        user, size, volume, weight,
                        shipmentDate,
                        destinationDate,
                        shipmentpoint,
                        destinationpoint,
                        1
                );
            }

        }
        if (user != null) {
            if (user.getRole() == User.Role.client) {
                logger.info("getting lastOrdersList");
                Order[] orders = serviceFactory.getOrderService().getOrdersOfUser(user);
                logger.info("lastOrderList length = " + orders.length);
                request.setAttribute("order_last", orders);
            }
        }

        return ret;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandExecutionException {
        return null;
    }
}