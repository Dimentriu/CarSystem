package main.java.by.itoverone.repository;

import main.java.by.itoverone.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByLogin(String login);

}