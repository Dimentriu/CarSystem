package main.java.by.itoverone.service;

import main.java.by.itoverone.entity.User;

import java.util.Optional;

@Service

public interface UserService {

    Optional<User> findByLogin(String login);

}