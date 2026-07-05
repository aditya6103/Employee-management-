package com.wozo.employee_management.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


        private long id;

           @NotBlank(message = "Firstname should not be empty")
           @Pattern(regexp ="^[a-zA-Z ]+$", message = "firstname should contains only Alphabet")
           private String firstName;

        @NotBlank(message = "Lastname should not be empty")
        @Pattern(regexp ="^[a-zA-Z ]+$", message = "Lastname should contains only Alphabet")
        private String lastName;

        @Email
        @NotBlank(message = "Email is required")
        private String email;


}
