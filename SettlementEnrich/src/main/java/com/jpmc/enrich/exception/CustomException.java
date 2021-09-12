package com.jpmc.enrich.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@ToString
public class CustomException extends Exception {
    private String message;
    private HttpStatus status;
}
