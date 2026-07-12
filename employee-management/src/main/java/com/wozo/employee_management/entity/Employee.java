package com.wozo.employee_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

    @Column(name="first_name")
     private String firstName;

    @Column(name="last_name")
     private String lastName;

    @Column(nullable = false,unique = true)
     private String email;

   @ManyToOne
   @JoinColumn(name = "department_id")
   private Department department;



}
