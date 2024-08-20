package com.example.demo.user.controller;

import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor // DI on userService
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
        @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

}
