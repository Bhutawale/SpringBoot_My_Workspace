package com.example.restaurant_management.service;

import java.util.List;


import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Bill;
import com.example.restaurant_management.model.Ratings;

public interface AdminServiceI 
{	
	public Admin addAdmin(Admin admin); 
	
	
	public Ratings findAllRatingsByCustomerId(int customerId);
	
	public List<Bill> findAllBillByCustomerName(String customerName);
	
	public List<Bill> SearchAllBillByDate(String billDate);
	
	public void deleteAdmin(int adminId);
	
	public Admin updateAdmin(Admin admin);
}
