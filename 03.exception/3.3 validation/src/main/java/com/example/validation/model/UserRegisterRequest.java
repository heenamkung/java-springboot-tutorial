package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
    private static final Logger log = LoggerFactory.getLogger(UserRegisterRequest.class);
    //@NotBlank

    private String name;
    private String nickName;

    //No annotation exists for if either name / nickName exist: need to make it
    //@AssertTrue only works when method name starts with "is"
    @AssertTrue(message = "name of nickName must exist")
    public boolean isNameCheck(){
        return (Objects.nonNull(name)  && !name.isBlank()) || (Objects.nonNull(nickName) && !nickName.isBlank());
    }


    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber(message = "phone number doesn't match")// custom annotation we made in PhoneNumber.java
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;
}
