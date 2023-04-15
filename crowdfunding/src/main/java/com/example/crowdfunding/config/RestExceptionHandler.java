package com.example.crowdfunding.config;

import com.example.crowdfunding.dto.ErrorDto;
import com.example.crowdfunding.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException e) {
        return ResponseEntity.status(e.getCode()).body(ErrorDto.builder().message(e.getMessage()).build());
    }
}
