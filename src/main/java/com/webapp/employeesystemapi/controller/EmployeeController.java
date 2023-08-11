package com.webapp.employeesystemapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.employeesystemapi.entity.EmployeeEntity;
import com.webapp.employeesystemapi.model.Employee;
import com.webapp.employeesystemapi.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployeeData();
	}
	@DeleteMapping
	public void DeleteEmployee(@RequestParam long id) {
		 employeeService.deleteEmployee(id);
	}
}
