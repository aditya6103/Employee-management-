package com.wozo.employee_management.service;

import com.wozo.employee_management.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto fetchByIdService(Long id);

    List<EmployeeDto> fetchAllEmployeeService();

    EmployeeDto updateEmployeeService(Long id,EmployeeDto updatedEmployeeDto );


}
