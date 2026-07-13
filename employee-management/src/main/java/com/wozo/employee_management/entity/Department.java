package com.wozo.employee_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="department")
public class Department {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique=true,nullable = false)
    private String departmentName;

    @Column(unique = true,nullable = false)
    private String departmentCode;
    @Column(length = 500)
    private String departmentDescription;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
