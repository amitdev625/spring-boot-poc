package com.security.appsecurity1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.security.appsecurity1.entity.Employee;
import com.security.appsecurity1.model.EmployeeDTO;

public interface EmployeeService {
	public abstract Employee addEmployee(EmployeeDTO employee);

	public abstract List<Employee> getAllEmployees();

	public abstract void deleteEmployeeById(Integer id);

	public abstract ResponseEntity<Employee> updateEmployee(Integer id, Employee employee);

	public abstract ResponseEntity<Employee> getEmployeeByID(Integer id);
}
