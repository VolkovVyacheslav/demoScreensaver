package com.example.demoscreensaver;

import com.example.demoscreensaver.config.Config;
import com.example.demoscreensaver.service.ColorFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoScreensaverApplication {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }

//        SpringApplication.run(DemoScreensaverApplication.class, args);
    }

}
