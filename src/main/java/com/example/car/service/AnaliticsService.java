package com.example.car.service;

import com.example.car.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface AnaliticsService {

    List<User> getTopMoneyUsers(long usersCount);

    Map<String, Integer> getNewUsersByCountry(LocalDateTime start1, LocalDateTime end1);

    Map<Long, LocalDateTime> getActivityByUser(String uuid, LocalDateTime start2, LocalDateTime end2);
}
