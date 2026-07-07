package com.wozo.employee_management.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;


}
