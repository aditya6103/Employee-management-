package com.wozo.employee_management.controller;


import com.wozo.employee_management.dto.DepartmentDto;
import com.wozo.employee_management.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@AllArgsConstructor
@RestController
public class DepartmentController {


    DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> createDepartmentController( @Valid @RequestBody DepartmentDto departmentDto)
    {

        DepartmentDto departmentDto1 = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentBYIdController(@PathVariable Long id)
    {
        DepartmentDto departmentById = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentById,HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartmentController()
    {
        List<DepartmentDto> allDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartments,HttpStatus.OK);
    }
    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> updateDepartmentController( @PathVariable Long id,@Valid @RequestBody DepartmentDto departmentDto )
    {
        DepartmentDto departmentDto1 = departmentService.updateDepartment(id, departmentDto);
        return new ResponseEntity<>(departmentDto1,HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartmentByIdController(@PathVariable Long id)
    {

        departmentService.deleteDepartment(id);
        return  ResponseEntity.ok("id deleted successfully");

    }



}
