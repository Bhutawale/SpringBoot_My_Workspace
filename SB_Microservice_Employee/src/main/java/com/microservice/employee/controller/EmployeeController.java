package com.microservice.employee.controller;

import java.util.List;

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

import com.microservice.employee.entity.Employee;
import com.microservice.employee.service.EmployeeServiceI;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeServiceI empservice;

	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{
		try
		{
			empservice.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.OK).body("Employee Saved Successfully!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong.");
		}
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id)
	{
		try
		{
			Employee emp = empservice.getEmployeeById(id);
			if(emp!=null && emp.getId()==id)
			{
				empservice.deleteEmployee(id);
				return ResponseEntity.status(HttpStatus.OK).body("Employee deleted Successfully!!");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with given Id "+id +" Not Found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong.");
		}
	}
	
	@GetMapping("/employeeById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id)
	{
		try
		{
			Employee employeeById = empservice.getEmployeeById(id);
			
			if(employeeById!=null)
			{
				return ResponseEntity.status(HttpStatus.FOUND).body(employeeById);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with given Id "+id+" Not Found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong.");

		}
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees()
	{
		try 
		{	
			List<Employee> allEmployees = empservice.getAllEmployees();
			if(!allEmployees.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employees Found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong.");
		}
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,@PathVariable int id)
	{
		try
		{
			Employee updatedEmployee = empservice.updateEmployee(employee, id);
			if(updatedEmployee!=null && updatedEmployee.getId()==id)
			{
				return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Not found so not Updated!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong.");
		}
	}
}
