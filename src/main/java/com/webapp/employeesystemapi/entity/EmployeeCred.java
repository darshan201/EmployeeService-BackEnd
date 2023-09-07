package com.webapp.employeesystemapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
@Table(name = "employeescred")
public class EmployeeCred {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String emailId;
	
	private String userName;
	private String password;
}