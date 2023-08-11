package com.webapp.employeesystemapi.service;

import java.util.List;

import com.webapp.employeesystemapi.entity.EmployeeEntity;
import com.webapp.employeesystemapi.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee>  getAllEmployeeData();

	void deleteEmployee(long id);

}
