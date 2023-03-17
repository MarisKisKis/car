package com.example.car.repository;

import com.example.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUuid(String uuid);

    List<User> findTopUserCountByMoneyOrderByCountryDesc(long userCount);

    List<User> findUsersByFirstTimestampIsAfterStart1AndFirstTimestampIsBeforeEnd1(LocalDateTime start1, LocalDateTime end1);
}
