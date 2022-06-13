package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    protected ExceptionMessage handleConflict(HttpServletRequest request, ResourceNotFoundException exception) {
        return new ExceptionMessage(HttpStatus.NOT_FOUND.value(),
                "1000", "Requested resource not found.");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ExceptionMessage handleConflict(HttpServletRequest request, BadRequestException exception) {
        return new ExceptionMessage(HttpStatus.BAD_REQUEST.value(),
                "1000", exception.getMessage());
    }
}
