package com.example.rest_api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // post body: user_name, received as userName
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    //if datatype is boolean, @Data makes SetKorean() not SetIsKorean, causing error. Hence, use Boolean
    private Boolean isKorean;
}
