package main.java.by.itoverone.repository;

import java.util.Optional;

public interface JpaRepository<T, T1> {
    Optional<Client> findById(Integer id);
}
