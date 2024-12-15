package com.microservice.company.controller;

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

import com.microservice.company.entity.Company;
import com.microservice.company.service.CompanyServiceI;

@RestController
@RequestMapping("/company")
public class CompanyController
{
	@Autowired
	private CompanyServiceI companyservice;
	
	@PostMapping("/saveCompany")
	public ResponseEntity<?> saveCompany(@RequestBody Company company)
	{
		try
		{
			companyservice.saveCompany(company);
			return ResponseEntity.status(HttpStatus.OK).body("Company Data Saved Successfully.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
	
	@DeleteMapping("/deleteCompany/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable int id)
	{
		try
		{
			Company companyById = companyservice.getCompanyById(id);
			if(companyById!=null && companyById.getId()==id)
			{
				companyservice.deleteCompany(id);
				return ResponseEntity.status(HttpStatus.OK).body("Company with id "+id +" deleted successfully.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id "+id +" not found in the database.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
	
	@GetMapping("/companyById/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable int id)
	{
		try
		{
			Company companyById = companyservice.getCompanyById(id);
			if(companyById!=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body(companyById);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id "+id +" not found in the database.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
	
	@GetMapping("/getAllCompanies")
	public ResponseEntity<?> getAllCompanies()
	{
		try
		{
			List<Company> allCompanies = companyservice.getAllCompanies();
			if(!allCompanies.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(allCompanies);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
	
	@PutMapping("/updateCompany/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody Company company,@PathVariable int id)
	{
		try
		{
			Company updatedCompany = companyservice.updateCompany(company, id);
			if(updatedCompany!=null && updatedCompany.getId()==id)
			{
				return ResponseEntity.status(HttpStatus.OK).body(updatedCompany);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Company found to update");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
	
	@GetMapping("/getCompanyByEmployeeId/{eid}")
	public ResponseEntity<?> getCompanyByEmployeeId(@PathVariable int eid)
	{
		try
		{
			List<Company> companyByEmployeeId = companyservice.getCompanyByEmployeeId(eid);
			if(companyByEmployeeId.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Data Found.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body(companyByEmployeeId);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
}
