package com.example.car.service;

import com.example.car.model.User;
import com.example.car.repository.StatsRepository;
import com.example.car.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional(readOnly = true)
public class AnaliticsServiceImpl implements AnaliticsService {

    private final StatsRepository statsRepository;
    private final UserRepository userRepository;

    @Autowired
    public AnaliticsServiceImpl(StatsRepository statsRepository, UserRepository userRepository) {
        this.statsRepository = statsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getTopMoneyUsers(long usersCount) {
        return userRepository.findTopUserCountByMoneyOrderByCountryDesc(usersCount);
    }

    @Override
    public Map<String, Integer> getNewUsersByCountry(LocalDateTime start1, LocalDateTime end1) {
        List<User> newUsers = userRepository.findUsersByFirstTimestampIsAfterStart1AndFirstTimestampIsBeforeEnd1(start1,
                end1);
        List<String> countries = new ArrayList<>();
        for (User user : newUsers) {
            countries.add(user.getCountry());
        }
        return null;
    }

    @Override
    public Map<Long, LocalDateTime> getActivityByUser(String uuid, LocalDateTime start2, LocalDateTime end2) {
        return null;
    }
}
