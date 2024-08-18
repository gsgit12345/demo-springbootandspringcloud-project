package com.example.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request)
    {
        ErrorMessage error=new ErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<Object>(error,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNPException(Exception ex, WebRequest request)
    {
        System.out.println("in np handler");
        ErrorMessage error=new ErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<Object>(error,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request)
    {
        System.out.println("in np UserServiceException");
        ErrorMessage error=new ErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<Object>(error,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
