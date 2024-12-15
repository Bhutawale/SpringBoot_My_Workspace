package com.microservice.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.employee.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> 
{
	
}
