package com.example.car.controller;

import com.example.car.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sinc")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserData(@RequestParam String uuid) {
        String userData = userService.getUserData(uuid);
        log.info("Получаем данные");
        return userData;
    }

    @PostMapping
    public String acceptUserData(@RequestParam String jsonData, @RequestParam String uuid) {
        try {
            userService.saveData(jsonData, uuid);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        log.info("Сохраняем данные синхранизации");
        return "Данные успешно сохранены";
    }

    @PostMapping
    public String acceptUserStat(@RequestParam Long activity, @RequestParam String uuid) {
        userService.saveGameStats(activity, uuid);
        log.info("Сохраняем данные игровой статистики");
        return "Данные успешно сохранены";
    }
}
