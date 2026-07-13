package com.wozo.employee_management.service;

import com.wozo.employee_management.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto fetchByIdService(Long id);

    Page<EmployeeDto> fetchAllEmployeeService(int page,int size,String sortBy,String sortDir);

    EmployeeDto updateEmployeeService(Long id,EmployeeDto updatedEmployeeDto );

    void deleteEmployee(Long id);


}
