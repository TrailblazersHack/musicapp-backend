package ru.trailblazers.musicappbackend.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Data
public class ServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
