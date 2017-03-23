package com.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class EmployeeControllerTest {

	@InjectMocks //@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance
	EmployeeController employeeController;
	
	
	//This method is executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class)
	@Before //@Before causes that method to be run before the Test method
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test //The @Test annotation identifies a method as a test method
	public void display_emp() throws JsonGenerationException, JsonMappingException, IOException,Exception
	{
		ModelAndView modelAndView = employeeController.display_emp();
		List<Employee> employees= (List<Employee>)modelAndView.getModel().get("el");
		assertNotNull(modelAndView);
		assertNotNull(employees);
		assertEquals(5,employees.size());
		assertNotEquals(4,employees.size());
		assertEquals(employees.get(0).getEid(),1001);
		assertEquals(employees.get(0).getEmpname(),"John");
		assertNotNull(modelAndView.getModel());
	}
	
}