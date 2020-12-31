package com.demo.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.demo.thymeleafdemo.dto.EmployeeDto;
import com.demo.thymeleafdemo.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.thymeleafdemo.dao.EmployeeRepository;
import com.demo.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeDto> findAll() {
		List<Employee> emp_list = employeeRepository.findAll();

		return emp_list.stream()
				.map(employeeMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}



	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}






