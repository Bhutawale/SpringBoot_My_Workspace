package com.microservice.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.company.dao.CompanyDao;
import com.microservice.company.entity.Branches;
import com.microservice.company.entity.Company;

@Service
public class CompanyServiceImpl  implements CompanyServiceI 
{
	@Autowired
	private CompanyDao companydao;

	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public Company saveCompany(Company company)
	{
		Company saveCompany = companydao.save(company);
		return saveCompany;
	}

	@Override
	public void deleteCompany(int id) 
	{
		companydao.deleteById(id);
	}

	@Override
	public Company getCompanyById(int id) 
	{
		Company companyById = companydao.findById(id).orElse(null);
		
		//System.out.println(companyById);
		try
		{
			List<Branches> branches = resttemplate.exchange
					("http://localhost:3133/branch/getBranchesByCompanyId/"+companyById.getId(),
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Branches>>() {}).getBody();
		
			//System.out.println(branches);
			
			companyById.setBranch(branches);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return companyById;
	}

	@Override
	public List<Company> getAllCompanies() 
	{
		List<Company> allCompanies = companydao.findAll();
		return allCompanies;
	}

	@Override
	public Company updateCompany(Company company, int id) 
	{
		Optional<Company> existingCompany = companydao.findById(id);
		if(existingCompany.isPresent())
		{
			Company companyToUpdate = existingCompany.get();
			
			companyToUpdate.setName(company.getName());
			
			Company updatedCompany = companydao.save(companyToUpdate);
			
			return updatedCompany;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Company> getCompanyByEmployeeId(int eid) 
	{
		List<Company> companyByEmployeeId = companydao.getCompanyByEmployeeId(eid);
		return companyByEmployeeId;
	}
	
}
