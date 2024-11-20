package com.auction.product_service.handler;

import com.auction.product_service.error.ErrorResponse;
import com.auction.product_service.exception.InsufficientFundsException;
import com.auction.product_service.exception.ProductUnavailableException;
import com.auction.product_service.exception.ProductNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductUnavailableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleProductUnavailable(ProductUnavailableException ex) {
        return new ErrorResponse("PRODUCT_UNAVAILABLE", ex.getMessage());
    }

    @ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    public ErrorResponse handleInsufficientFunds(InsufficientFundsException ex) {
        return new ErrorResponse("INSUFFICIENT_FUNDS", ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleProductNotFound(ProductNotFoundException ex) {
        return new ErrorResponse("PRODUCT_NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(exp.getMessage());
    }
}







