package com.wozo.employee_management.service.impl;

import com.wozo.employee_management.Exception.ResourceNotFoundException;
import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.entity.Employee;
import com.wozo.employee_management.mapper.EmployeeMapper;
import com.wozo.employee_management.repository.EmployeeRepository;
import com.wozo.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

       Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee= employeeRepository.save(employee);
      return EmployeeMapper.mapToEmployeeDto(savedEmployee);


    }

    @Override
    public EmployeeDto fetchByIdService(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not found" + "id is " + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> fetchAllEmployeeService() {

        List<EmployeeDto> employeeDtos= new ArrayList<>();

        List<Employee> all = employeeRepository.findAll();

        List<EmployeeDto> collect = all.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
        return collect;



    }

    @Override
    public EmployeeDto updateEmployeeService(Long id, EmployeeDto updatedEmployeeDto) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                             () -> new ResourceNotFoundException("Is id not present" + id));
                   employee.setFirstName(updatedEmployeeDto.getFirstName());
                   employee.setLastName(updatedEmployeeDto.getLastName());
                   employee.setEmail(updatedEmployeeDto.getEmail());

                 Employee updatedemployee=  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedemployee);
    }


}
