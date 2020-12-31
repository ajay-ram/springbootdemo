package com.demo.thymeleafdemo.service;

import java.util.List;

import com.demo.thymeleafdemo.dto.EmployeeDto;
import com.demo.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<EmployeeDto> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);

	public void deleteById(int theId);
	
}
