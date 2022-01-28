package main.java.by.itoverone.service;

import main.java.by.itoverone.entity.Driver;
import main.java.by.itoverone.entity.Order;
import main.java.by.itoverone.entity.OrderResult;

import java.io.ObjectInputFilter;
import java.util.List;
import java.util.Optional;

@Service
public interface DriverService {
    List<Order> getAllClientOrders(Integer id);

    void createOrder(String tourType, String typeOfPayment, Driver client) throws EntityNotFoundException;

    void deletedOrders(Driver client, Integer order_id);

    List<Order> getDeletedOrders(Integer clientId);

    List<Driver> findAllClients();

    Driver findById(Integer id);

    Integer findByOrderResults(Driver client, OrderResult done);

    void update(Integer id, ObjectInputFilter.Status status) throws EntityNotFoundException;
}