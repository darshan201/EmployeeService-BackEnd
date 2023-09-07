package com.webapp.employeesystemapi.service;

import java.util.List;

import com.webapp.employeesystemapi.entity.EmployeeCred;
import com.webapp.employeesystemapi.entity.EmployeeEntity;
import com.webapp.employeesystemapi.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployeeData();

	void deleteEmployee(long id);

	Employee getEmployeeById(long id);

	Employee updateEmplyee(long id, Employee employee);
	
	// cred method

	boolean saveEmployeeCred(EmployeeCred employeeCred);

	EmployeeCred getEmployeeCreByEmailId(String EmailId);

}
