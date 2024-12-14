package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;

import com.example.service.EmployeeserviceI;


@RestController
@RequestMapping("/employee")
public class Employeecontroller {

	@Autowired
	private EmployeeserviceI e;
	
	@PostMapping("/insert")
	public ResponseEntity<?> addEmp(@RequestBody Employee emp) throws EmployeeNotFoundException
	{
		Employee e1 = e.addEmployee(emp);
	
		String ename=e1.getName();
		String ecity=e1.getCity();
		
		if(ename!=null && ecity!=null)
		//if(e1!=null)
			return new ResponseEntity<>(e1,HttpStatus.CREATED);
		else
			throw new EmployeeNotFoundException("Null Values entered in the table.Please insert valid data.");
		
	}
	
	@GetMapping("/showEmployee")
	public ResponseEntity<List<Employee>> showEmployee()
	{
		
		List<Employee> list = e.show();
		if(list.size()<1)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp) throws EmployeeNotFoundException
	{
		Employee e2 = e.update(emp);
		if(e2!=null)
			return new ResponseEntity<>(e2,HttpStatus.CREATED);
			else
				//return new ResponseEntity<>(e2,HttpStatus.NOT_FOUND);
				throw new EmployeeNotFoundException("Employee not found");
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		e.delete(id);
		
	}
	
	@GetMapping("/byname/{name}")
	public Employee getByName(@PathVariable String name)
	{
		Employee e4 = e.ByName(name);
		return e4;
		
	}
	
	
}
