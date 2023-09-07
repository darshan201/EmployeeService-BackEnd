package com.webapp.employeesystemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.employeesystemapi.entity.EmployeeCred;
@Repository
public interface EmployeeCredRepo extends JpaRepository<EmployeeCred, String>{

}
