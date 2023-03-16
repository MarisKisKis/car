package com.example.car.service;

import com.example.car.model.Stats;
import com.example.car.model.User;
import com.example.car.repository.StatsRepository;
import com.example.car.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StatsRepository statsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, StatsRepository statsRepository) {
        this.userRepository = userRepository;
        this.statsRepository = statsRepository;
    }

    @Override
    public void saveData(String jsonData, String uuid) throws JSONException {
        JSONObject data = new JSONObject(jsonData);
        Long money = data.getLong("money");
        String country = data.getString("country");
        if (userRepository.findUserByUuid(uuid) != null) {
            User user = userRepository.findUserByUuid(uuid);
            user.setJsonData(jsonData);
            user.setMoney(money);
        } else {
            User user = new User(uuid, money, country, jsonData, LocalDateTime.now());
            userRepository.save(user);
        }
    }

    @Override
    public String getUserData(String uuid) {
        String userData = userRepository.findUserByUuid(uuid).getJsonData();
        return userData;
    }

    @Override
    public void saveGameStats(Long activity, String uuid) {
        Stats stat = new Stats(activity, LocalDateTime.now(), uuid);
        statsRepository.save(stat);
    }
}
