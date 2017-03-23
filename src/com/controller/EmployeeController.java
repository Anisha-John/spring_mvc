package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	ArrayList<Employee> list = getmethod();
	ObjectMapper map = new ObjectMapper();
	HttpServletRequest httpServletRequest;

	public EmployeeController() {
	}

	public ArrayList<Employee> getmethod() {

		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee emp1 = new Employee(1001, "John", "Portal", "P12", 40000);
		Employee emp2 = new Employee(1002, "Ancy", "Portal", "P12", 40000);
		Employee emp3 = new Employee(1003, "Shreya", "SDP", "P10", 30000);
		Employee emp4 = new Employee(1004, "Akhil", "EAI", "P23", 40000);
		Employee emp5 = new Employee(1005, "Steve", "Portal", "P12", 40000);
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		return list;

	}

	

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public ModelAndView display_emp() throws Exception {
		System.out.println(httpServletRequest.getAttributeNames());
		return new ModelAndView("emp", "el", list);
	}

}
