package com.example.visao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.visao.exceptions.ApiErrors;
import com.example.visao.exceptions.RegradeNegocioException;
@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    @ExceptionHandler(RegradeNegocioException.class)
    public ApiErrors handlerRegraNegocioException(RegradeNegocioException ex) {
    return new ApiErrors(ex.getMessage());
    }
}
