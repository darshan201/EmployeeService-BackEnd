package com.webapp.employeesystemapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.employeesystemapi.entity.EmployeeCred;
import com.webapp.employeesystemapi.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cre")
public class EmployeeCreditialController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public boolean saveCredential(@RequestBody EmployeeCred employeeCred) {
		return employeeService.saveEmployeeCred(employeeCred);
		
	}
	
	@GetMapping("/employees/{emailId}")
	public EmployeeCred getEmployeeCred(@PathVariable("emailId") String emailId) {
		return employeeService.getEmployeeCreByEmailId(emailId);
		
	}

}
