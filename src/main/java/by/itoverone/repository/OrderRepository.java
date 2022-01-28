package main.java.by.itoverone.repository;

import main.java.by.itoverone.entity.Order;

import java.util.List;

    public interface OrderRepository extends JpaRepository<Order, Integer> {
        List<Order> findAllByClientAndAndPaymentStatus(Integer id);
    }