package com.demo.thymeleafdemo.controller;

import java.util.List;


import com.demo.thymeleafdemo.dto.EmployeeDto;
import com.demo.thymeleafdemo.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.thymeleafdemo.entity.Employee;
import com.demo.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRestController employeeRestController;


	@Autowired
	private EmployeeMapper employeeMapper;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<EmployeeDto> employeeDtos = employeeRestController.findAll();
		theModel.addAttribute("employees", employeeDtos);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		EmployeeDto employeeDto = new EmployeeDto();
		
		theModel.addAttribute("employee", employeeDto);
		
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		EmployeeDto employeeDto = employeeMapper.toDto(employeeRestController.getEmployee(theId));
		theModel.addAttribute("employee", employeeDto);
		
		// send over to our form
		return "employees/employee-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employeeDto") EmployeeDto employeeDto) {
		
		// save the employee
		Employee employee = employeeMapper.toModel(employeeDto);

		if(employee.getId()==0){
			employeeRestController.addEmployee(employee);
		}
		else {
			employeeRestController.updateEmployee(employee);
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeRestController.deleteEmployee(theId);
		
		// redirect to /employees/list
		return "redirect:/employees/list";
		
	}
}


















