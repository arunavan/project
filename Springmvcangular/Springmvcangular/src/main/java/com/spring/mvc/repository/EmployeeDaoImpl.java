package com.spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.spring.mvc.component.Employee;

@Repository
public class EmployeeDaoImpl {

	// Method to generate the dummy employee records.
	public List<Employee> getAllEmployeesFromDb() {

		// To generate the fake details for the employees.
		Faker faker = new Faker();

		// Employee list.
		List<Employee> employeelist = new ArrayList<Employee>();

		// Creating fake employees to be shown on the angular html page.
		for(int i=101; i<=110; i++) {

			// Creating employee model objects.
			Employee myemployee = new Employee();
			myemployee.setId(i);
			myemployee.setName(faker.name().fullName());
			myemployee.setMobile(faker.phoneNumber().cellPhone());
			myemployee.setAddress(faker.address().streetAddress());
			myemployee.setCompanylogo(faker.company().logo());

			// Adding the employee records to the employee list.
			employeelist.add(myemployee);
		}

		return employeelist;
	}
}