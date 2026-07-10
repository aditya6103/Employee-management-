package com.wozo.employee_management.repository;

import com.wozo.employee_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {



}
