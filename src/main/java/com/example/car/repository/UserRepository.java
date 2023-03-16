package com.example.car.repository;

import com.example.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUuid(String uuid);
}
