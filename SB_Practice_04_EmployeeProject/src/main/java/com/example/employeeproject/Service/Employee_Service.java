package com.example.employeeproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeproject.Dao.Employee_Dao;
import com.example.employeeproject.Entity.Employee;

@Service
public class Employee_Service 
{
	@Autowired
	private Employee_Dao dao;
	
	public Employee saveEmployee(Employee emp)
	{
		Employee employee = dao.save(emp);
		return employee;
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> findAll = dao.findAll();
		return findAll;
	}
	
	public Employee getEmpById(int id)
	{
		Employee employee = dao.findById(id).get();
		return employee;
	}
	
	public void deleteEmp(int id)
	{
		dao.deleteById(id);
	}
	
	public Employee updateEmp(Employee emp,int id)
	{
		Employee updatedEmp = dao.save(emp);
		return updatedEmp;
	}
	
	public List<Employee> getEmpByCity(String city)
	{
		List<Employee> empByCity = dao.getEmpByCity(city);
		return empByCity;
	}
	
	public void deleteAllEmp()
	{
		dao.deleteAll();
	}
	
	public List<Employee> getEmpByCompanyAndCity(String company,String city)
	{
		List<Employee> empByCompanyNameAndCity = dao.getEmpByCompanyNameAndCity(company, city);
		return empByCompanyNameAndCity;
	}
	
	public List<Employee> getEmpSalaryGreaterThan(int salary)
	{
		List<Employee> empSalaryGreaterThan = dao.getEmpSalaryGreaterThan(salary);
		return empSalaryGreaterThan;
	}
	
	public List<Employee> getEmpNameStartWithLetter(String letter)
	{
		List<Employee> empNameStartWithLetter = dao.getEmpNameStartWithLetter(letter);
		return empNameStartWithLetter;
	}
	
	public List<Employee> getEmpExpByCompanyName(String company)
	{
		List<Employee> empExpByCompanyName = dao.getEmpExpByCompanyName(company);
		return empExpByCompanyName;
	}
}
