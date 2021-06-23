package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AppController {
	
	@Autowired
	Utility utility;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("getEmp/{id}/{techId}")
	@HystrixCommand(fallbackMethod = "recoveryMethod")
	public ResponseEntity getEmployee(@PathVariable int id,@PathVariable int techId) {
		
		Employee emp=utility.getEmp(id);
		
		List<ServiceInstance> list=discoveryClient.getInstances("TECHNOLOGYSERVICE");
		
		ServiceInstance instance=list.get(0);
		
		URI  uri=instance.getUri();
		
		Technology technology=new RestTemplate().getForObject(uri+"/getTech/"+techId, Technology.class);
		
		emp.setTechnology(technology);
		
		return new ResponseEntity(emp,HttpStatus.OK);
		
	}
	
	public ResponseEntity recoveryMethod(@PathVariable int id,@PathVariable int techId) {
		
		return new ResponseEntity("Please try after some time",HttpStatus.OK);
	}
	

}
