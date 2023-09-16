package com.ordermanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    private HttpStatus status;
}
