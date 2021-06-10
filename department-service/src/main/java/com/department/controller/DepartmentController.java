package com.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.DepartmentDTO;
import com.department.service.DepartmentService;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {

	private final DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDto) {
		return ResponseEntity.ok(departmentService.addDepartment(departmentDto));
	}
	
	@GetMapping("/getDeptByEmpId")
	public ResponseEntity<DepartmentDTO> getDeptByEmpId(@RequestParam long empId) {
		return ResponseEntity.ok(departmentService.getDeptByEmpId(empId));
	} 
	
	
	
}
