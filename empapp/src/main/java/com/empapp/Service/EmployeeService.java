package com.empapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.Entity.Employee;
import com.empapp.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;//Create object Through Dependency-Injection
	
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
		
	}

	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		
	}
	public void updateEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	public Optional<Employee> findEmployeeById(long id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		return byId;
		
	}
	
}
