package com.bmu.Springcoredemo.config;

import com.bmu.Springcoredemo.common.Coach;
import com.bmu.Springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
