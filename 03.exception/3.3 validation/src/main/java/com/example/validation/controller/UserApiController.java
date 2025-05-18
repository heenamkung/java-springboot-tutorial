package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<UserRegisterRequest> register(
            @Valid // runs validation process when receiving object
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest
            ){
        //Body is never called when error validating userRegisterRequest. It just throws exception that is caught in exception handler.
        log.info("init : {} ", userRegisterRequest);

        var body = userRegisterRequest.getData();
        var response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();
        return response;
    }


}
