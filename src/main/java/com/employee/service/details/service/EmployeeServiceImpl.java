package com.employee.service.details.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.service.details.entity.Employee;
import com.employee.service.details.enums.ProjectType;
import com.employee.service.details.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Override
	public Employee getEmployee(int empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		if(Objects.isNull(ProjectType.valueOf(employee.getProjectType()))) {
			throw new Exception("Invalid Project Type:{}");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	public boolean removeEmployee(int empId) {
		return false;
	}

	@Override
	public List<Employee> getProject(String projectType) {
		// TODO Auto-generated method stub
		return employeeRepository.findByProjectType(projectType);
	}

}
