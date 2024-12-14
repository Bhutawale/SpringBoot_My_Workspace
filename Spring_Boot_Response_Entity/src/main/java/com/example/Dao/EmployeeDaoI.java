package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee;

public interface EmployeeDaoI extends JpaRepository<Employee, Integer> {

	public Employee findByName(String name);
}
