package com.revision;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.revision.entities.Employee;
import com.revision.repository.EmployeeRepository;

@SpringBootApplication
public class RevSbProject01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RevSbProject01Application.class, args);
		
		EmployeeRepository repo =context.getBean(EmployeeRepository.class);
		/*
		 *  SAVE Employee
		 * 
		Employee emp=new Employee();
		emp.setName("Sanskruti");
		
		Address address=new Address();
		address.setCity("Florida");
		address.setCountry("USA");
		
		emp.setAddress(address);
		
		Employee save_emp = repo.save(emp);
		
		System.out.println("Employee Saved Successfully."+save_emp);
		*/
		
		/*
		 * Fetch All Employees.
		 * 
		List<Employee> allEmployees = repo.findAll();
		allEmployees.stream().forEach(System.out::println);
		
		*/
		
		
		/*
		 * Update Employee
		
		Optional<Employee> findById = repo.findById(2);
		Employee employee = findById.get();
		employee.setName("Virat");
		
		Address address = employee.getAddress();
		
		address.setCity("Panvel");
		address.setCountry("India");
		
		employee.setAddress(address);
		
		repo.save(employee);
		
		System.out.println("Employee Updated Successfully.");
		
		*/
		
		/*
		 * Delete Employee 
		 * 
		repo.deleteById(1);
		
		System.out.println("Employee Deleted Successfully.");
		
		*/
		
		
		
		//Employee employee = repo.findByName("Sanskar");
		//System.out.println(employee);
		
		
	
		//List<Employee> findByCity = repo.findByAddress_City("Pune");
		//System.out.println(findByCity);
		
		
		List<Employee> findBYNameAndCity = repo.findBYNameAndCity("Virat", "Panvel");
		System.out.println(findBYNameAndCity);
	}

}
