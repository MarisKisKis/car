package com.example.car.controller;

import com.example.car.model.User;
import com.example.car.service.AnaliticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/analitics")
@Slf4j
public class AnaliticsController {

    private final AnaliticsService analiticsService;

    @Autowired
    public AnaliticsController(AnaliticsService analiticsService) {
        this.analiticsService = analiticsService;
    }

    @GetMapping
    public void getAnalitics(@RequestParam int usersCount, @RequestParam LocalDateTime start1,
                             @RequestParam LocalDateTime end1, @RequestParam String uuid,
                             @RequestParam LocalDateTime start2,
                             @RequestParam LocalDateTime end2){
        List<User> task1 =  analiticsService.getTopMoneyUsers(usersCount);
        Map<String, Integer> countNew = analiticsService.getNewUsersByCountry(start1, end1);
        Map<Long, LocalDateTime> activityStat =  analiticsService.getActivityByUser(uuid, start2, end2);
    }
}
