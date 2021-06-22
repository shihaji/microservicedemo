package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	
	Technology[] techAr= {
			
			new Technology(1,"java"),
			new Technology(2,"mysql"),
			new Technology(3,"dotnet"),
			new Technology(4,"angular"),
	};
	
	
	public Technology getTech(int techId) {
		
		for(Technology t:techAr) {
			
			if(t.getTechId()==techId) {
				return t;
			}
			
		}
	   return null;	
	}
	

}
