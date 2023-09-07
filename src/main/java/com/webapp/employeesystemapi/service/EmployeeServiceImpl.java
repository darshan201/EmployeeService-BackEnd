package com.webapp.employeesystemapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webapp.employeesystemapi.entity.EmployeeCred;
import com.webapp.employeesystemapi.entity.EmployeeEntity;
import com.webapp.employeesystemapi.model.Employee;
import com.webapp.employeesystemapi.repository.EmployeeCredRepo;
import com.webapp.employeesystemapi.repository.EmployeeRepository;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeCredRepo employeeCredRepo;

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
		EmployeeEntity employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);

	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee employee = new Employee();
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

	@Override
	public Employee updateEmplyee(long id, Employee employee) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		employeeEntity.setEmailId(employee.getEmailId());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeRepository.save(employeeEntity);
		return employee;
	}

	/// Cred service method saving employee cred data
	@Override
	public boolean saveEmployeeCred(EmployeeCred employeeCred) {

		boolean validEmail = employeeCredRepo.findById(employeeCred.getEmailId()).get().getEmailId().isEmpty();

		if (validEmail) {
			return !validEmail;
		} else {
			employeeCredRepo.save(employeeCred);
			return validEmail;
		}

	}

	@Override
	public EmployeeCred getEmployeeCreByEmailId(String EmailId) {
		try {
			return employeeCredRepo.findById(EmailId).orElseThrow();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
