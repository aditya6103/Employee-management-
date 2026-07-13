package com.wozo.employee_management.mapper;


import com.wozo.employee_management.dto.DepartmentDto;
import com.wozo.employee_management.entity.Department;

public class DepartmentMapper {



    public static DepartmentDto mapToDto(Department department)
    {
       return new  DepartmentDto(
               department.getId(),
               department.getDepartmentName(),
               department.getDepartmentCode(),
               department.getDepartmentDescription()

       );


    }

    public static Department mapToDepartment(DepartmentDto departmentDto)
    {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentDescription(),
                null


        );


    }
}
