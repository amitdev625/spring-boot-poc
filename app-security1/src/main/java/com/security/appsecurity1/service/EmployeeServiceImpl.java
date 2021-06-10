package com.security.appsecurity1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.security.appsecurity1.entity.Employee;
import com.security.appsecurity1.model.DepartmentDTO;
import com.security.appsecurity1.model.EmployeeDTO;
import com.security.appsecurity1.repository.EmployeeRepository;
import com.security.appsecurity1.web.client.DepartmentMSFeignClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DepartmentMSFeignClient departmentMSFeignClient;

	@Override
	public Employee addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(0, employeeDTO.getName(), employeeDTO.getAge(), employeeDTO.getMobile());
		Employee emp = employeeRepository.save(employee);
		DepartmentDTO department = new DepartmentDTO();
		department.setDepName(employeeDTO.getDepName());
		department.setEmployeeId(emp.getId());
		ResponseEntity<DepartmentDTO> response = restTemplate
				.postForEntity("http://localhost:8084/api/v1/addDepartment", department, DepartmentDTO.class);
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
		Employee employeeForUpadate = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Employee Not Found For The Id " + id));
		employeeForUpadate.setAge(employee.getAge());
		employeeForUpadate.setMobile(employee.getMobile());
		employeeForUpadate.setName(employee.getName());
		Employee updatedEmployee = employeeRepository.save(employeeForUpadate);
		return ResponseEntity.ok(updatedEmployee);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeByID(Integer id) {

		ResponseEntity<DepartmentDTO> deptByEmpId = departmentMSFeignClient.getDeptByEmpId(id);
		System.out.println(deptByEmpId.getBody());

		return ResponseEntity.ok(employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Employee Not Found For The Id " + id)));
	}

}
