package com.ordermanagement.exception;

import com.ordermanagement.dto.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<DefaultResponse> handleApiException(ApiException e){
        return ResponseEntity.status(e.getStatus()).body(new DefaultResponse(e.getMessage(),false,e.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponse> handleValidationException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultResponse(e.getFieldErrors().toString(),false,HttpStatus.BAD_REQUEST));
    }
}
