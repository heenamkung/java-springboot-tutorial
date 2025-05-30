package com.example.demo.user.controller;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor // inject userService from Spring
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

    @DeleteMapping("/id/{id}")
    public void delete(
           @PathVariable long id
    ){
        userService.delete(id);
    }

    @GetMapping("id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get();
    }


}
