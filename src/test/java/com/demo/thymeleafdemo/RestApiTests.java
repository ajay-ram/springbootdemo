package com.demo.thymeleafdemo;


import com.demo.thymeleafdemo.controller.EmployeeRestController;
import com.demo.thymeleafdemo.dto.EmployeeDto;
import com.demo.thymeleafdemo.entity.Employee;
import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiTests {
	@Mock
	EmployeeRestController employeeRestController;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllEmployeesTest()
	{
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		EmployeeDto empOne = new EmployeeDto(1, "ajay", "ram", "ajay@gmail.com");
		EmployeeDto empTwo = new EmployeeDto(2, "test", "user", "testuser@yahoo.com");

		list.add(empOne);
		list.add(empTwo);

		when(employeeRestController.findAll()).thenReturn(list);

		//test
		List<EmployeeDto> empList = employeeRestController.findAll();

		assertEquals(2, empList.size());
		verify(employeeRestController, times(1)).findAll();
	}

	@Test
	public void getEmployeeByIdTest()
	{
	    Employee mockEmp= new Employee(1, "ajay", "ram", "ajay@gmail.com");
		when(employeeRestController.getEmployee(1)).thenReturn(mockEmp);

		Employee emp = employeeRestController.getEmployee(1);
        System.out.println(emp);
		assertEquals("ajay", emp.getFirstName());
		assertEquals("ram", emp.getLastName());
		assertEquals("ajay@gmail.com", emp.getEmail());
	}

	@Test
	public void createEmployeeTest()
	{

		Employee emp = new Employee(1, "ajay", "ram", "ajay@gmail.com");
		employeeRestController.addEmployee(emp);
		verify(employeeRestController, times(1)).addEmployee(emp);
	}

	@Test
	public void updateEmployeeTest()
	{

		Employee emp = new Employee(1, "ajay", "ram", "ajay@gmail.com");
		employeeRestController.updateEmployee(emp);
		verify(employeeRestController, times(1)).updateEmployee(emp);
	}

	@Test
	public void deleteEmployeeTest()
	{

		employeeRestController.deleteEmployee(1);
		verify(employeeRestController, times(1)).deleteEmployee(1);
	}

}

