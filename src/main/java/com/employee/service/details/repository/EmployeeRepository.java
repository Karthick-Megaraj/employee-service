package com.employee.service.details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.service.details.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByProjectType(String projectType);

}
