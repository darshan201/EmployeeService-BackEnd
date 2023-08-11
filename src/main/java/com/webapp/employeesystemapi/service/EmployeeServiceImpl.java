package com.webapp.employeesystemapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webapp.employeesystemapi.entity.EmployeeEntity;
import com.webapp.employeesystemapi.model.Employee;
import com.webapp.employeesystemapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		List<Employee> employees = employeeEntities.stream()
				.map(emp -> new Employee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId()))
				.collect(Collectors.toList());
		return employees;
	}

	@Override
	public void deleteEmployee(long id) {
		 EmployeeEntity employee= employeeRepository.findById(id).orElseThrow();
		employeeRepository.delete(employee);
	}

}
