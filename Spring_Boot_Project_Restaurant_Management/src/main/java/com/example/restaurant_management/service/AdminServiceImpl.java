package com.example.restaurant_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant_management.dao.AdminDaoI;
import com.example.restaurant_management.model.Admin;

import com.example.restaurant_management.model.Customer_Rating;
import com.example.restaurant_management.model.Sell;

@Service
public class AdminServiceImpl implements AdminServiceI
{
	@Autowired
	private AdminDaoI admindao;
	
	public Admin addAdmin(Admin admin) 
	{
		return admindao.save(admin);
	}

	public List<Sell> findAllSellById(int sellId) 
	{
		return admindao.findAllSellById(sellId);
	}

	public List<Admin> showallAdmin() 
	{
		return admindao.findAll();
	}

	public List<Customer_Rating> showratingbyid(int customerId) 
	{
		return admindao.findAllRatingById(customerId);
	}

	public List<Sell> findAllSellByDate(String sellDate) 
	{
		return admindao.findAllSellByDate(sellDate);
	}

	public Admin updateAdmin(Admin admin) 
	{
		return admindao.save(admin);
	}

	public void deleteSell(int sellId) 
	{
		admindao.deleteById(sellId);		
	}

	

}
