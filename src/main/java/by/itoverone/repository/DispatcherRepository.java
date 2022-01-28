package main.java.by.itoverone.repository;

import main.java.by.itoverone.entity.Dispatcher;

import java.util.Optional;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Integer> {

    Optional<Dispatcher> findAgentByLogin(String login);

}