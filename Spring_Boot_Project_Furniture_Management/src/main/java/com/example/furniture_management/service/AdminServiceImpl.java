package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.furniture_management.dao.AdminDaoI;
import com.example.furniture_management.exception.AdminNotFoundException;
import com.example.furniture_management.model.Admin;

@Service
public class AdminServiceImpl implements AdminServiceI 
{
	@Autowired
	private AdminDaoI admindao;
	
	//adding Admin
	public Admin addAdmin(Admin admin) throws AdminNotFoundException 
	{
		Admin addAdmin = admindao.findById(admin.getAdminId()).orElse(null);
		if(addAdmin==null)
		{
			return	admindao.save(admin);
		}
		else
		{
			throw new AdminNotFoundException("Admin Already Exists.Please enter another Admin");
		}
	}

	
	//Displaying Admin
	public List<Admin> showAdmin()
	{
		return admindao.findAll();
	}

	
	//Deleting Admin using Id
	public void deleteAdminbyId(int adminId) 
	{
		admindao.deleteById(adminId);	
	}	

	
	//Deleting All Admins from the database
	public void deleteAllAdmin() 
	{
		admindao.deleteAll();
	}
	
	
	//Updating Admin 
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException 
	{
		Admin updateAdmin = admindao.findById(admin.getAdminId()).orElse(null);
		if(updateAdmin==null)
		{
			throw new AdminNotFoundException("No Such Admin exists!!");
		}
		else
		{
			return admindao.save(admin);
			 
		}
				
	}

	//Searching Admin by Id
	public Optional<Admin> findAdminbyId(int adminId) 
	{
		return admindao.findById(adminId);
			
	}


	


	

	
	
}
