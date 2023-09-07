package com.webapp.employeesystemapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@DeleteMapping("employees/{id}")
	public void DeleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		// need to imporove as per video
	}

	@GetMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable("id")  long id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}
	@PutMapping("employees/{id}")
	public Employee updateEmployee(@PathVariable("id")  long id ,@RequestBody Employee employee) {
		employeeService.updateEmplyee(id,employee);
		return employee;
	}
}
