package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.EmployeeDaoI;
import com.example.model.Employee;
@Service
public class EmployeeserviceImpl implements EmployeeserviceI {

	@Autowired
	private EmployeeDaoI d;
	
	@Override
	public Employee addEmployee(Employee emp) {
		
		return d.save(emp);
	}
	@Override
	public List<Employee> show() {
		List<Employee> list = d.findAll();
		return list;
	}
	@Override
	public Employee update(Employee emp) {
		Employee e2 = d.save(emp);
		return e2;
	}
	@Override
	public void delete(int id) {
		d.deleteById(id);
		
	}
	@Override
	public Employee ByName(String name) {
		Employee e3 = d.findByName(name);
		return e3;
	}

}
