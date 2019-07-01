package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.component.Employee;
import com.spring.mvc.repository.EmployeeDaoImpl;

@Service
public class EmployeeServImpl {

	@Autowired
	EmployeeDaoImpl empdao;

	public List<Employee> getAllEmployees() {
		return empdao.getAllEmployeesFromDb();
	}
}