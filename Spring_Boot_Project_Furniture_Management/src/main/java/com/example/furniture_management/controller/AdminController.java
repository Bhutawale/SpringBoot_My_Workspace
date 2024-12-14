package com.example.furniture_management.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.furniture_management.exception.AdminNotFoundException;
import com.example.furniture_management.model.Admin;
import com.example.furniture_management.service.AdminServiceI;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminServiceI adminservice;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin) throws AdminNotFoundException
	{
		adminservice.addAdmin(admin);
		System.out.println("Admin Added Successfully");
		return new ResponseEntity<>("Admin Added Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/showAdmin")
	public ResponseEntity<List<Admin>> showAdmin() throws AdminNotFoundException
	{
		List<Admin> showAdmin = adminservice.showAdmin();
		if(showAdmin.size()<1)
		{
			throw new AdminNotFoundException("Admin Not Found in the Database!!");
		}
		else
		{
			return ResponseEntity.of(Optional.of(showAdmin));
		}
	}
	
	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<?> deleteAdminbyId(@PathVariable int adminId)
	{
		
		adminservice.deleteAdminbyId(adminId);
		System.out.println("Admin Deleted Successfully");
		return new ResponseEntity<>("Admin Deleted Successfully.",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletealladmin")
	public ResponseEntity<?> deleteAllAdmin() throws AdminNotFoundException 
	{
		adminservice.deleteAllAdmin();
		return new ResponseEntity<>("All Admin Deleted Successfully",HttpStatus.OK);
	}
	
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException
	{
		adminservice.updateAdmin(admin);
		System.out.println("Admin Updated Successfully");
		return new ResponseEntity<>("Admin Updated Successfully.",HttpStatus.OK);
	}
	
	@GetMapping("/findAdminbyId/{adminId}")
	public Optional<Admin> findAdminbyId(@PathVariable int adminId)
	{
		return adminservice.findAdminbyId(adminId);
	}
	
}
