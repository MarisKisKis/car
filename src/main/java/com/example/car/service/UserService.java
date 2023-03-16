package com.example.car.service;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface UserService {

    String getUserData(String uuid);

    void saveData(String jsonData, String uuid) throws JSONException;

    void saveGameStats(Long activity, String uuid);
}
