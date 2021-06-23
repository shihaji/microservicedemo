package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGatewayApplication.class, args);
	}
	
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		
		
		return builder.routes().route(t->t.path("/getEmp/**").uri("lb://EMPLOYEESERVICE"))
				               .route(t->t.path("/getMessage/**").uri("lb://MYAPPLICATION"))
				               .build();
		
	}

}
