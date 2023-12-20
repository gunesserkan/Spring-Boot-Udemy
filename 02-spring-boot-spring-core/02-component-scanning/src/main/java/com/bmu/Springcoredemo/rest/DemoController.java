package com.bmu.Springcoredemo.rest;

import com.bmu.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // bağımlılık iççin özel alan tanımlanması
    private Coach myCoach;
    // bağımlılık enjeksiyonu için kurucu tanımlanması
    @Autowired
    public DemoController(Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
