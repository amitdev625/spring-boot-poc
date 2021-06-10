package com.security.appsecurity1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.appsecurity1.entity.Employee;
import com.security.appsecurity1.model.EmployeeDTO;
import com.security.appsecurity1.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody EmployeeDTO employee) {
		Employee emp = service.addEmployee(employee);
		return emp;
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return employees;
	}

	@GetMapping("/getEmployeeByID/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable(value = "id") Integer id) {
		ResponseEntity<Employee> response = service.getEmployeeByID(id);
		return response;
	}

	@DeleteMapping("/deleteEmployee")
	public void deleteEmployee(@RequestParam Integer id) {
		service.deleteEmployeeById(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

}
