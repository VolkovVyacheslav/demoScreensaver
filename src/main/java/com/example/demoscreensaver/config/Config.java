package com.example.demoscreensaver.config;

import com.example.demoscreensaver.service.ColorFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.example.demoscreensaver")
public class Config {

    @Bean
    @Scope(value = "periodical")
    public Color color(){
        Random  random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }


}
