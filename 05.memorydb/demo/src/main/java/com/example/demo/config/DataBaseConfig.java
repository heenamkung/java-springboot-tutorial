package com.example.demo.config;

import com.example.demo.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Another way of setting UserRepository as a bean.
//Easy way is to make UserRepository not final and use @AutoWired in UserService.java
//Another way is to add @Service to UserRepository.java
/*
@Configuration
public class DataBaseConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

}
*/