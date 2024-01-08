package com.example.dtoslearning.config;

import com.example.dtoslearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CacheInitializer implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Override
    public void run(String... args) throws Exception {
        String userId = "14";
        String userData = String.valueOf(userService.findById(Integer.valueOf(userId)));
        System.out.println("Cached user data: " + userData);
        System.out.println("***********************************************");
    }
}
