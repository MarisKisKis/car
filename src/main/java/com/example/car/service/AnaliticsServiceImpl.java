package com.example.car.service;

import com.example.car.repository.StatsRepository;
import com.example.car.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
