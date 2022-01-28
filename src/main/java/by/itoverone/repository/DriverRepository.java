package main.java.by.itoverone.repository;

import main.java.by.itoverone.entity.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository <Driver, Integer> {

    Optional<Driver> findAgentByLogin(String login);

}
