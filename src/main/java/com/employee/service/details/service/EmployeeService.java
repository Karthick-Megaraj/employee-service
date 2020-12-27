package com.employee.service.details.service;

import java.util.List;

import com.employee.service.details.entity.Employee;

public interface EmployeeService {
	
	
	public Employee getEmployee(int empId);
	
	
	public Employee addEmployee(Employee employee) throws Exception;
	
	
	public Employee updateEmployee(Employee employee);
	
	
	public boolean removeEmployee(int empId);


	public List<Employee> getProject(String projectType);

}
