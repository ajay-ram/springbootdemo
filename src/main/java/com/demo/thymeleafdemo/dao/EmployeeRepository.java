package com.demo.thymeleafdemo.dao;

import com.demo.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
