package com.wozo.employee_management.controller;


import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {


    EmployeeService employeeService;

    @PostMapping("/Employees")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto)
    {

        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }


    @GetMapping("/Employees/{id}")
    public ResponseEntity<EmployeeDto> fetchByIdController(@PathVariable Long id)
    {
        EmployeeDto employeeDto = employeeService.fetchByIdService(id);

        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    @GetMapping("/Employees")
    public ResponseEntity<List<EmployeeDto>> fetchAllEmployeeController()
    {
        List<EmployeeDto> employeeDtos = employeeService.fetchAllEmployeeService();

        return new ResponseEntity<>(employeeDtos,HttpStatus.OK);

    }

    @PutMapping("/Employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeController(@PathVariable Long id,@RequestBody EmployeeDto updatedEmployee)
    {
        EmployeeDto employeeDto = employeeService.updateEmployeeService(id, updatedEmployee);

        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    @DeleteMapping("/Employees/{id}")
    public ResponseEntity<Long> deleteEmployeeByID(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(id,HttpStatus.OK);


    }


}
