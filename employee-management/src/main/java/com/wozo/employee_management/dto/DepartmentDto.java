package com.wozo.employee_management.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;

    @NotBlank(message = "Department name is required")
    @Pattern(regexp ="^[a-zA-Z ]+$",
            message = "Department name should contains only alphabet")
    private String departmentName;

    @NotBlank(message = "Department code is required")
    private String departmentCode;

    @NotBlank(message = "Department description is required")
    @Pattern(regexp ="^[a-zA-Z ]+$",
            message = "Department description should contains only character")
    private String departmentDescription;


}
