package com.controller;


	import static org.junit.Assert.assertNotNull;
	import static org.mockito.Matchers.any;
	import static org.mockito.Mockito.when;

	import java.io.IOException;
	import java.util.ArrayList;

	import org.codehaus.jackson.JsonGenerationException;
	import org.codehaus.jackson.map.JsonMappingException;
	import org.codehaus.jackson.map.ObjectMapper;
	import org.junit.Before;
	import org.junit.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

	public class Idcontrollertest {

		@InjectMocks //@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance
		IdController idController;
		
		@Mock
		ObjectMapper mapper=new ObjectMapper();
		@Mock
		EmployeeController ec = new EmployeeController();
		@Mock
		Employee employee = new Employee();

		
		//This method is executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class)
		@Before //@Before causes that method to be run before the Test method
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}
		
		
		@Test //The @Test annotation identifies a method as a test method
		public void display_emp() throws JsonGenerationException, JsonMappingException, IOException,Exception
		{
			int mock_eid=1002;
			
		/*	String jsonList = "[{'eid':3,'empname':'John','emp_project':'Portal','pid':'P12','esalary':40000}," +
			                   "{'eid':4,'empname':'Ancy','emp_project':'Portal','pid':'P12','esalary':40000}]";
			
			when(mapper.writeValueAsString(any(ArrayList.class))).thenReturn(jsonList);
*/			
			ModelAndView modelAndView = idController.display_emp(mock_eid);
			
			System.out.println("modelAndView\n\n" + modelAndView);
			
			String jsonString= modelAndView.getModel().get("el").toString();
			
			System.out.println(" jsonString\n\n " + jsonString);
			
			assertNotNull(modelAndView);
			assertNotNull(jsonString);
			assertNotNull(modelAndView.getModel());
			
		}
		
		
		
	}

