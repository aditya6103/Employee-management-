package com.wozo.employee_management.repository;

import com.wozo.employee_management.entity.AppUser;
import com.wozo.employee_management.entity.Role;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long> {


    boolean existsByRoleName(String roleName);

    Role findByRoleName(String roleName);

}
