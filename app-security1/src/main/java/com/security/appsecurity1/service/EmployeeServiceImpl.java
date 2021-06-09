package com.security.appsecurity1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.appsecurity1.entity.Employee;
import com.security.appsecurity1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Integer id, Employee employee) {
		Employee employeeForUpadate = 
				 employeeRepository.
				 findById(id).
				 orElseThrow(() -> new IllegalArgumentException("Employee Not Found For The Id " + id));
		employeeForUpadate.setAge(employee.getAge());
		employeeForUpadate.setMobile(employee.getMobile());
		employeeForUpadate.setName(employee.getName());
		Employee updatedEmployee = employeeRepository.save(employeeForUpadate);
		return ResponseEntity.ok(updatedEmployee);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeByID(Integer id) {
		return 
			ResponseEntity.
			ok(employeeRepository.findById(id).
		    orElseThrow(()-> new IllegalArgumentException("Employee Not Found For The Id " + id)));
	}

}
