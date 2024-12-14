package com.example.employeeproject.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.employeeproject.Entity.Employee;
import com.example.employeeproject.Service.Employee_Service;

@Controller
public class Employee_Controller 
{
	@Autowired
	private Employee_Service service;
	
		
	@PostMapping("/saveEmp")
	@ResponseBody
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee emp,BindingResult result)
	{
		if(result.hasErrors())
		{
			List<String> validation = result.getAllErrors()
					.stream()
					.map(error->error.getDefaultMessage())
					.collect(Collectors.toList());
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validation);
		}
		else
		{
			Map<Employee, String> map=new HashMap<Employee, String>();
			Employee employee = service.saveEmployee(emp);
			map.put(employee, "Employee Saved Successfully!!");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
	}
	
	@GetMapping("/getAllEmp")
	@ResponseBody
	public ResponseEntity<?> getAllEmployees()
	{
		
		List<Employee> findAll = service.getAllEmployees();
		if(!findAll.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(findAll);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Employee Exist!!");
		}
	}
	
	@GetMapping("/getEmpById/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getEmpById(@PathVariable int id)
	{
		
		
		Map<String,Object> map=new HashMap<>();
		try
		{
			Employee empById = service.getEmpById(id);
			map.put("message", "Employee Found!!");
			map.put("employee", empById);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			map.put("message", "Employee with given id "+ id +" Not Found!!");
			map.put("employee", null);
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
			
		}
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteEmp(@PathVariable int id)
	{
		try
		{
			service.deleteEmp(id);
			String succ_msg="Employee Deleted Successfully!!";
			return ResponseEntity.status(HttpStatus.OK).body(succ_msg);
		}
		catch(Exception e)
		{
			String err_msg="Something Went Wrong, No Such Employee Exist!!";
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err_msg);
		}
	}
	
	@PutMapping("/updateEmp/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateEmp(@RequestBody Employee emp,@PathVariable int id)
	{
		Map<String, Object> map=new HashMap<>();
		
		Employee employee = service.getEmpById(id);
		if(employee.getId()==id)
		{
			employee.setName(emp.getName());
			employee.setSalary(emp.getSalary());
			employee.setCity(emp.getCity());
			employee.setCompany_name(emp.getCompany_name());
			
			Employee updateEmp = service.updateEmp(employee, id);
			String succ_msg="Employee Data Successfully Updated!!";
			map.put(succ_msg, updateEmp);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		else
		{
			String err_msg="Something Went Wrong!!";
			map.put(err_msg, null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping("/getEmpByCity/{city}")
	public ResponseEntity<Object> getEmpByCity(@PathVariable String city)
	{
		
		Map<List<Object>, String> map=new HashMap<>();
		Map<String,String> error=new HashMap<>();
		
		List<Employee> empByCity = service.getEmpByCity(city);
		if(empByCity!=null && !empByCity.isEmpty())
		{
			String succ_msg="All Employees in the city: "+city;
			map.put(new ArrayList<>(empByCity), succ_msg);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		else
		{
			String err_msg="No Employee found in the city: "+city;
			error.put("error", err_msg);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
	}
	
	@DeleteMapping("/deleteAllEmp")
	@ResponseBody
	public ResponseEntity<String> deleteAllEmp()
	{
		List<Employee> allEmployees = service.getAllEmployees();
		if(!allEmployees.isEmpty())
		{
			service.deleteAllEmp();
			return ResponseEntity.status(HttpStatus.OK).body("All Employess Deleted Successfully!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Employee Exist to delete!!");
		}
	}
	
	@GetMapping("/getEmpByCompanyAndCity/{company}/{city}")
	@ResponseBody
	public ResponseEntity<?> getEmpByCompanyAndCity(@PathVariable String company,@PathVariable String city)
	{
		List<Employee> empByCompanyAndCity = service.getEmpByCompanyAndCity(company, city);
		if(!empByCompanyAndCity.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(empByCompanyAndCity);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee found for the given Company and city!!");
		}
	}
	
	@GetMapping("/getEmpSalaryGreaterThan/{salary}")
	@ResponseBody
	public ResponseEntity<?> getEmpSalaryGreaterThan(@PathVariable int salary)
	{
		List<Employee> empSalaryGreaterThan = service.getEmpSalaryGreaterThan(salary);
		if(!empSalaryGreaterThan.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(empSalaryGreaterThan);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee found with given Salary");
		}
	}
	
	@GetMapping("/getEmpNameStartWithLetter/{letter}")
	public ResponseEntity<?> getEmpNameStartWithLetter(@PathVariable String letter)
	{
		List<Employee> empNameStartWithLetter = service.getEmpNameStartWithLetter(letter);
		if(!empNameStartWithLetter.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(empNameStartWithLetter);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee Name Found starting with letter "+ letter);
		}
	}
	
	@GetMapping("/getEmpExpByCompanyName/{company}")
	public ResponseEntity<?> getEmpExpByCompanyName(@PathVariable String company)
	{
		List<Employee> empExpByCompanyName = service.getEmpExpByCompanyName(company);
		if(!empExpByCompanyName.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(empExpByCompanyName);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee have experience of the given company "+company);
		}
	}
}
