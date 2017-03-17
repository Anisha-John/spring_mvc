package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller

public class EmployeeController {
	
	public ArrayList getmethod(){
		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee emp1= new Employee(1001,"Joseph","Portal","P12",40000);
		Employee emp2= new Employee(1002,"Ancy","Portal","P12",40000);
		Employee emp3= new Employee(1003,"Shreya","SDP","P10",30000);
		Employee emp4= new Employee(1004,"Akhil","EAI","P23",40000);
		Employee emp5= new Employee(1005,"Steve","Portal","P12",40000);



		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		
		return list;

	}
	
	@RequestMapping(value="/getAllEmployees",method = RequestMethod.GET)
	 public String display_emp(ModelMap model) throws Exception{
		
		String json = "Null";
		
		ArrayList<Employee> list = getmethod();
		
/*//		Employee emp1= new Employee(11,"Revu","Portal",30000);
//		Employee emp2= new Employee(12,"Harsha","Portal",40000);
//		list.add(emp1);
//		list.add(emp2);
*/	
		for(Employee employee  : list) {
		     System.out.println(employee.getEid());
		    System.out.println(employee.getEmp_project());
		}
		
		ObjectMapper map= new ObjectMapper();
		 json=map.writeValueAsString(list);
		model.addAttribute("el", json);
		//System.out.println("HEllo");
		return "emp";
		

			}

}
