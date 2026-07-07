package com.wozo.employee_management.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ErrorDetails> handleResourceNotFoundException
            (ResourceNotFoundException ex, WebRequest web)
    {
         ErrorDetails errorDetails= new ErrorDetails(

                 LocalDateTime.now(),
                 HttpStatus.NOT_FOUND.value(),
                 ex.getMessage(),
                 web.getDescription(false)
         );

         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> handleValidationfailedException
            (MethodArgumentNotValidException ex)
    {
        Map<String,String> errors= new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors())
        {
            errors.put(error.getField(),error.getDefaultMessage());
        }
          return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
