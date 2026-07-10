package com.wozo.employee_management.service;


import com.wozo.employee_management.dto.DepartmentDto;
import com.wozo.employee_management.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment( DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long id);

   List<DepartmentDto> getAllDepartments();

   DepartmentDto updateDepartment( Long id,DepartmentDto departmentDto);

    void deleteDepartment(Long id);






}
