package com.wozo.employee_management.service.impl;

import com.wozo.employee_management.Exception.ResourceNotFoundException;
import com.wozo.employee_management.dto.DepartmentDto;
import com.wozo.employee_management.dto.EmployeeDto;
import com.wozo.employee_management.entity.Department;
import com.wozo.employee_management.entity.Employee;
import com.wozo.employee_management.mapper.DepartmentMapper;
import com.wozo.employee_management.mapper.EmployeeMapper;
import com.wozo.employee_management.repository.DepartmentRepository;
import com.wozo.employee_management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;



    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {


        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saved = departmentRepository.save(department);

        return DepartmentMapper.mapToDto(saved);

    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                     () -> new ResourceNotFoundException("Department is not found with given id" + id));

        return DepartmentMapper.mapToDto(department);

    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> repositoryAll = departmentRepository.findAll();
        List<DepartmentDto> collected = repositoryAll.stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());


        return collected;
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("id is not found" + id));

          department.setDepartmentName(departmentDto.getDepartmentName());
          department.setDepartmentCode(departmentDto.getDepartmentCode());
          department.setDepartmentDescription(departmentDto.getDepartmentDescription());

        Department saved = departmentRepository.save(department);

        return DepartmentMapper.mapToDto(saved);

    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("id is not present " + id));
        departmentRepository.delete(department);

    }
}
