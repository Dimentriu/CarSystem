package main.java.by.itoverone.entity;

import java.util.Objects;

@Entity
@Table(name = "user")

public class User {
    private int id;
    private String username;

    public enum Role {
        client, driver, dispatcher
    }

    private Role role;

    //todo: change string ty safwe type from java.security

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRoleFromInt(int i) {
        this.role = Role.values()[i];
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
