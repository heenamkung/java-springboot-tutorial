package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // only returns JSON because it's REST API
// @Controller // can return html response. there used to be only controller
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    // @RequestMapping(path = "", method = RequestMethod.GET) // same as GetMapping
    // When using @controller, need to add extra @ResponseBody to return JSON
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setUserName("hee");
        user.setUserAge(32);
        user.setEmail("abc@gmail.com");

        var response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("x-custom", "hi")
                .body(user);

        return response;
    }
}
