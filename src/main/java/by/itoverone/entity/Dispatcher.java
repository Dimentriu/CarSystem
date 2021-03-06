package main.java.by.itoverone.entity;

import java.util.Objects;

@Entity
@Table(name = "dispatcher")

public class Dispatcher extends User{
    public Dispatcher(int dispatcherId, int userId, int maxDrivers) {
        this.dispatcherId = dispatcherId;
        this.userId = userId;
        this.maxDrivers = maxDrivers;
    }

    private int dispatcherId;

    private int userId;

    private int maxDrivers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispatcher that = (Dispatcher) o;
        return dispatcherId == that.dispatcherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dispatcherId);
    }

    public void setMaxDrivers(int maxDrivers) {
        this.maxDrivers = maxDrivers;
    }

    public int getDispatcherId() {
        return dispatcherId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMaxDrivers() {
        return maxDrivers;
    }

    @Override
    public String toString() {
        return "Dispatcher{" +
                "dispatcherId=" + dispatcherId +
                ", userId=" + userId +
                ", maxDrivers=" + maxDrivers +
                '}';
    }
}