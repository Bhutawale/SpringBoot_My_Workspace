package com.microservice.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.employee.dao.EmployeeDao;
import com.microservice.employee.entity.Branches;
import com.microservice.employee.entity.Company;
import com.microservice.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI 
{
	@Autowired
	private EmployeeDao empdao;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public Employee saveEmployee(Employee employee)
	{
		Employee saveEmployee = empdao.save(employee);
		return saveEmployee;
	}

	@Override
	public void deleteEmployee(int id) 
	{
		empdao.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(int id) 
	{
		Employee findById = empdao.findById(id).orElse(null);
		
		//System.out.println(findById);
		
//		String jsonResponse = resttemplate.getForObject(
//			    "http://localhost:3132/company/getCompanyByEmployeeId/" + findById.getId(),
//			    String.class
//			);
//			System.out.println("Raw JSON Response: " + jsonResponse);
		
		if(findById==null)
		{
			return null;
		}
		try
		{
			List<Company> companies = resttemplate.exchange(
				    "http://localhost:3132/company/getCompanyByEmployeeId/" + findById.getId(),
				    HttpMethod.GET,
				    null,
				    new ParameterizedTypeReference<List<Company>>() {}
				).getBody();

			//System.out.println(companies);
			
			for(Company c:companies)
			{
				try 
	                {
	                	List<Branches> branches = resttemplate.exchange
	        					("http://localhost:3133/branch/getBranchesByCompanyId/"+c.getId(),
	        				HttpMethod.GET, 
	        				null, 
	        				new ParameterizedTypeReference<List<Branches>>() {}).getBody();
	                    
	                    System.out.println(branches);
	                    
	                    // Set branches in the company object
	                    c.setBranch(branches);
	                    
	                } 
	                catch (Exception e) 
	                {
	                    
	                    System.out.println(e.getMessage());
	                }
			
			findById.setCompany(companies);
			
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return findById;
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> allEmployees = empdao.findAll();
		
		return allEmployees;
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) 
	{
		Optional<Employee> existingEmp = empdao.findById(id);
		
		if(existingEmp.isPresent())
		{
			Employee empToUpdate = existingEmp.get();
			empToUpdate.setName(employee.getName());
			empToUpdate.setCity(employee.getCity());
			empToUpdate.setCompany(employee.getCompany());
			
			Employee updatedEmployee = empdao.save(empToUpdate);
			
			return updatedEmployee;
		}
		else
		{
			return null;
		}
	}
	
}
