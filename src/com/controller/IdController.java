package com.controller;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class IdController {
	
	int flag=1;
	String json;
	
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
}
}