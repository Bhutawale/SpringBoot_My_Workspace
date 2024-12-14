package com.example.restaurant_management.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Bill;

import com.example.restaurant_management.model.Ratings;
import com.example.restaurant_management.service.AdminServiceI;


@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminServiceI adminservice;
		
	
	@PostMapping("/addAdmin")
	public ResponseEntity<?> addAdmin(@Valid @RequestBody Admin admin)
	{
		adminservice.addAdmin(admin);
		System.out.println("Admin Added Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@GetMapping("/findAllBillByDate/{billDate}")
	public List<Bill> findAllBillByDate(@Valid @PathVariable String billDate)
	{
		return adminservice.SearchAllBillByDate(billDate);		
	}
	
	@GetMapping("/findAllRatingsByCustomerId/{customerId}")
	public Ratings findAllRatingsByCustomerId(@Valid @PathVariable int customerId)
	{
		return adminservice.findAllRatingsByCustomerId(customerId);
	}
	
	
	@GetMapping("/findAllBillByCustomerName/{customerName}")
	public List<Bill> findAllBillByCustomerName(@Valid @PathVariable String customerName)
	{
		return adminservice.findAllBillByCustomerName(customerName);
	}
	
	
	
	@DeleteMapping("/deleteAdminById/{adminId}")
	public void deleteAdmin(@Valid @PathVariable int adminId)
	{
		adminservice.deleteAdmin(adminId);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@Valid @RequestBody Admin admin)
	{
		return adminservice.updateAdmin(admin);
	}
	
	
}
