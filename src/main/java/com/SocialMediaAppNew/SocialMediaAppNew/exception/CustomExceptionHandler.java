package com.SocialMediaAppNew.SocialMediaAppNew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class CustomExceptionHandler extends  ResponseEntityExceptionHandler{


    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(true),
                 LocalDateTime.now()
                 );


      return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(true),
                LocalDateTime.now()
        );


        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }




}
