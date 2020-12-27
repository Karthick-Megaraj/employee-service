package com.employee.service.details.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.details.entity.Employee;
import com.employee.service.details.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empId){
		if(Objects.isNull(empId)) {
			log.info("employee Id Shout not be null: {}");
			return ResponseEntity.notFound().build();
		}
		Employee employee = service.getEmployee(empId);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/project/{projectType}")
	public ResponseEntity<List<Employee>> getEmployee(@PathVariable String projectType){
		if(Objects.isNull(projectType)) {
			log.info("projectType Shout not be null: {}");
			return ResponseEntity.notFound().build();
		}
		List<Employee> employee = service.getProject(projectType);
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee employee = null;
		try {
			employee = service.addEmployee(emp);
		} catch (Exception e) {
			log.warn("Invalid Project Type : {}",emp.getProjectType());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employee); 
		
	}
	
	@PutMapping("/change")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee employee = null;
		HttpStatus status=HttpStatus.OK;
			 if(Objects.isNull(service.getEmployee(emp.getEmployeeId()))){
				 status = HttpStatus.CREATED;
			 }
			 try {
				employee = service.addEmployee(emp);
			} catch (Exception e) {
				log.warn("Invalid Project Type : {}",emp.getProjectType());
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.status(status).body(employee); 
		
	}

}
