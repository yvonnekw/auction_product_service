package com.auction.product_service.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {


    private String errorCode;
    private String errorMessage;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
