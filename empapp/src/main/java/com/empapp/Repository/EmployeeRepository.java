package com.empapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empapp.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
	
	
}
