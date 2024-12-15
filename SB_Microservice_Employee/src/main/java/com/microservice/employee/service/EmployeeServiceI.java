package com.microservice.employee.service;

import java.util.List;

import com.microservice.employee.entity.Employee;

public interface EmployeeServiceI 
{
	public Employee saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployees();
	
	public Employee updateEmployee(Employee employee,int id);
}
