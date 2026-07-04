package com.wozo.employee_management.Exception;

public class ResourceNotFoundException extends RuntimeException{

   public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
