package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	
	Employee[] empAr= {
			
			new Employee(100,"abc",null),
			new Employee(200,"def",null),
			new Employee(300,"mno",null),
			new Employee(400,"pqr",null),
			
	};
	
	
	public Employee getEmp(int id) {
		
		for(Employee e:empAr) {
			
			if(e.getId()==id) {
				return e;
			}
		}
		
		return null;
	}

}
