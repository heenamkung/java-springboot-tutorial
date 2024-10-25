package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
* User error uses error code starting from 1000
*/

@AllArgsConstructor
@Getter // adds getErrorCode() automatically, which overrides the interface methods
public enum UserErrorCode implements ErrorCodeInterface
{
    USER_NOT_FOUND(400,1404,"User not found"),
    ;


    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
