package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public void put(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest.toString());
    }
}
