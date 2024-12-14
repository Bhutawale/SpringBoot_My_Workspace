package com.example.restaurant_management.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.restaurant_management.dao.AdminDaoI;
import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Bill;
import com.example.restaurant_management.model.Ratings;

@Service
public class AdminServiceImpl implements AdminServiceI 
{
	@Autowired
	private AdminDaoI admindao;

	
	public Admin addAdmin(Admin admin) 
	{
		return admindao.save(admin);
	}

	public List<Bill> SearchAllBillByDate(String billDate) 
	{
		List<Bill> findAllBillByDate = admindao.findAllBillByDate(billDate);
		
		if(findAllBillByDate.isEmpty())
		{
			System.out.println("No Orders/Bills Placed on the given date");
			return null;
		}
		else
		{
			System.out.println("Bills generated for the given Date.");
			return findAllBillByDate;
		}
	}

	public Ratings findAllRatingsByCustomerId(int customerId) 
	{
		return admindao.findAllRatingsByCustomerId(customerId);
	}
	
	public List<Bill> findAllBillByCustomerName(String customerName)
	{
		return admindao.findAllBillByCustomerName(customerName);
	}

	

	public void deleteAdmin(int adminId) 
	{
		admindao.deleteById(adminId);
	}
	
	public Admin updateAdmin(Admin admin)
	{
		return admindao.save(admin);
	}
	
}
