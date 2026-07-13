package com.wozo.employee_management.controller;

import org.springframework.data.domain.Page;
import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<EmployeeDto>> fetchAllEmployeeController(@RequestParam int page, @RequestParam int size,@RequestParam String sortBy,@RequestParam String sortDir)
    {

        Page<EmployeeDto> page1 = employeeService.fetchAllEmployeeService(page,size,sortBy,sortDir);

        return new ResponseEntity<>(page1,HttpStatus.OK);

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
