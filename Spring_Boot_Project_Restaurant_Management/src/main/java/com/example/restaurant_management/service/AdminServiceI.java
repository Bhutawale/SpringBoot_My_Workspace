package com.example.restaurant_management.service;


import java.util.List;

import com.example.restaurant_management.model.Admin;

import com.example.restaurant_management.model.Customer_Rating;
import com.example.restaurant_management.model.Sell;

public interface AdminServiceI 
{
	public Admin addAdmin(Admin admin);
	
	public List<Admin> showallAdmin();
	
	public List<Sell> findAllSellById(int sellId);
	
	public List<Customer_Rating> showratingbyid(int customerId);
	
	public List<Sell> findAllSellByDate(String sellDate);
	
	public Admin updateAdmin(Admin admin);
	
	public void deleteSell(int sellId);
}
