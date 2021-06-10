package com.security.appsecurity1.web.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.appsecurity1.model.DepartmentDTO;

@Component
@FeignClient(url = "http://localhost:8084/api/v1", name = "DEPARTMENT-MICROSERVICE")
public interface DepartmentMSFeignClient {

	@GetMapping("/getDeptByEmpId")
	public ResponseEntity<DepartmentDTO> getDeptByEmpId(@RequestParam long empId);
}
