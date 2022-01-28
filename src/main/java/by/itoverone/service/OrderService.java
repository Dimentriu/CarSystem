package main.java.by.itoverone.service;

import main.java.by.itoverone.entity.Order;
import main.java.by.itoverone.entity.User;

import java.util.Date;
import java.util.Optional;

public interface OrderService {
    public boolean addOrder(User user, float size, float volume, float weight, Date shipmentDate, Date destinationDate, String shipmentpoint, String destinationpoint, int purposeId);

    public Order getById(int id);

    public Order[] getOrdersOfUser(User user);

    public Order[] getUnsetOrders();
}