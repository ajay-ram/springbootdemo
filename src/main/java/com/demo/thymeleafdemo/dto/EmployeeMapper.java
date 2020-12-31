package com.demo.thymeleafdemo.dto;

import com.demo.thymeleafdemo.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toModel(EmployeeDto employeeDto);
    EmployeeDto toDto(Employee employee);
}
