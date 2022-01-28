package main.java.by.itoverone.service;

import main.java.by.itoverone.entity.User;

import java.util.Optional;

@Service

public interface Truckservice {
    public User logIn(String username, String password);

    public boolean register(User user, String username, int password);

    public boolean register(String username, String password);

    public boolean register(String username, String password, User.Role role);
}