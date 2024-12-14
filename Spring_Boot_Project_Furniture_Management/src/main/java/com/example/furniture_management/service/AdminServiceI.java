package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import com.example.furniture_management.exception.AdminNotFoundException;
import com.example.furniture_management.model.Admin;

public interface AdminServiceI 
{
	public Admin addAdmin(Admin emp) throws AdminNotFoundException;
	
	public List<Admin> showAdmin() throws AdminNotFoundException;
	
	public void deleteAdminbyId(int adminId);
	
	public void deleteAllAdmin();
	
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	
	public Optional<Admin> findAdminbyId(int adminId);
}
