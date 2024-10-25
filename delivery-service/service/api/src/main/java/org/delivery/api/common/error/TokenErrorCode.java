package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* Token error uses error code starting from 2000
*/

@AllArgsConstructor
@Getter // adds getErrorCode() automatically, which overrides the interface methods
public enum TokenErrorCode implements ErrorCodeInterface
{
    INVALID_TOKEN(400,2000,"Invalid Token"),
    EXPIRED_TOKEN(400,2001,"Expired Token"),
    TOKEN_EXCEPTION(400,2002,"Unknown Token Error")
    ;


    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
