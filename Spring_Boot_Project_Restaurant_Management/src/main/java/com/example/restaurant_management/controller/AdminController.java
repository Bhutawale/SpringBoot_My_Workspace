package com.example.restaurant_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Customer;
import com.example.restaurant_management.model.Customer_Rating;
import com.example.restaurant_management.model.Sell;
import com.example.restaurant_management.service.AdminServiceI;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminServiceI adminservice;
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return adminservice.addAdmin(admin);
	}
	
	@GetMapping("/showallAdmin")
	public List<Admin> findAllAdmin()
	{
		return adminservice.showallAdmin();
	}
	
	@GetMapping("/searchsellbyId/{sellId}")
	public List<Sell> findsellbyid(@PathVariable int sellId)
	{
		return adminservice.findAllSellById(sellId);
	}
	
	@GetMapping("/searchratingbyid/{customerId}")
	public List<Customer_Rating> findAllRatingById(@PathVariable int customerId)
	{
		return adminservice.showratingbyid(customerId);
	}
	
	@GetMapping("/searchsellbydate/{sellDate}")
	public List<Sell> findAllSellByDate(@PathVariable String sellDate)
	{
		return adminservice.findAllSellByDate(sellDate);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return adminservice.updateAdmin(admin);
	}
	
	@DeleteMapping("/deletesellbyid/{sellId}")
	public void deletesellbyid(@PathVariable int sellId)
	{
		adminservice.deleteSell(sellId);
	}
}
