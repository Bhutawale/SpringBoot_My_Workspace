package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeserviceI  {
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> show();
	
	public Employee update(Employee emp);
	
	public void delete(int id);
	
	public Employee ByName(String name);
}
