package com.wozo.employee_management.controller;


import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {


    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {

        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }


    @GetMapping("getEmployee/{id}")
    public ResponseEntity<EmployeeDto> fetchByIdController(@PathVariable Long id)
    {
        EmployeeDto employeeDto = employeeService.fetchByIdService(id);

        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }



}
