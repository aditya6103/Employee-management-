package com.wozo.employee_management.mapper;


import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto employeeDtoMap(Employee employee)
    {
        return new EmployeeDto(
                         employee.getId(),
                         employee.getEmail(),
                         employee.getFirstName(),
                         employee.getLastName()
        );
    }
// methods
    public static Employee employeeMap(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()

// true things
        );
    }



}
