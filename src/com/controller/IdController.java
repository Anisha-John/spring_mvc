package com.controller;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class IdController {
	
	public IdController(){}
	
	

	
	@RequestMapping(value="/getAllEmployees/{empid}",method = RequestMethod.GET) 
	public ModelAndView display_emp(@PathVariable int empid) throws Exception{
		EmployeeController ec = new EmployeeController();
		ObjectMapper map= new ObjectMapper();
		String json="Null";

		ArrayList<Employee> elist = ec.getmethod();
		for(Employee employee  : elist) {
			if( empid == employee.getEid()){	
			System.out.println("checked and same");
			 json= map.writeValueAsString(employee);
			}}
			
		
		return new ModelAndView("empdetails","el",json);
	}
	

	
	
//previous code	using modelmap
	
	/*int flag=1;
	String json="Null";
	
	EmployeeController ec = new EmployeeController();
		
	@RequestMapping(value="/getAllEmployees/{empid}",method = RequestMethod.GET) 
 public String display_emp(ModelMap model,@PathVariable int empid) throws Exception{
		System.out.print(empid);
		ObjectMapper map= new ObjectMapper();
		ArrayList<Employee> elist = ec.getmethod();
		for(Employee employee  : elist) {
			if( empid == employee.getEid())
			{	System.out.println("checked and same");
			 json= map.writeValueAsString(employee);
				model.addAttribute("el", json);
				 flag=0;
		}
	}
		if(flag==1)
		{	json="id is not available";
			model.addAttribute("el", json);
			}
		System.out.println(json);

return "empdetails";
}*/
}