package com.microservice.company.service;

import java.util.List;

import com.microservice.company.entity.Company;

public interface CompanyServiceI 
{
	public Company saveCompany(Company company);
	
	public void deleteCompany(int id);
	
	public Company getCompanyById(int id);
	
	public List<Company> getAllCompanies();
	
	public Company updateCompany(Company company,int id);
	
	public List<Company> getCompanyByEmployeeId(int eid);
}
