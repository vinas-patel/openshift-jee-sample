package com.app;

import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;

public class GetEmployees {

	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(78, "Simran"));
		list.add(new Employee(45, "Swapnali"));
		list.add(new Employee(79, "Mayur"));
		list.add(new Employee(13, "Vinas"));
		return list;
	}
	
}
