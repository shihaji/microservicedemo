package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	Utility utility;
	
	@GetMapping("getTech/{techId}")
	public ResponseEntity getTechnology(@PathVariable int techId) {
		
		Technology tech=utility.getTech(techId);
		
		return new ResponseEntity(tech,HttpStatus.OK);
		
	}

}
