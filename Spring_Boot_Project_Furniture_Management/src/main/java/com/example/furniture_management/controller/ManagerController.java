package com.example.furniture_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture_management.model.Manager;
import com.example.furniture_management.service.ManagerServiceI;

@RestController
@RequestMapping("/manager")
public class ManagerController 
{
	@Autowired
	private ManagerServiceI managerservice;
	
	@PostMapping("/addmanager")
	public Manager addManager(@RequestBody Manager manager)
	{
		return managerservice.addManager(manager);
	}
	
	@GetMapping("/showmanager")
	public List<Manager> showallManager()
	{
		return managerservice.showallManager();
	}
	
	@GetMapping("/showmanagerbyid/{managerId}")
	public Optional<Manager> showManagerbyId(@PathVariable int managerId)
	{
		return managerservice.showManagerbyId(managerId);
	}
	
	@PutMapping("/updatemanager")
	public Manager updateManager(@RequestBody Manager manager)
	{
		return managerservice.updateManager(manager);
	}
	
	@DeleteMapping("/deletemanagerbyid/{managerId}")
	public void deleteManagerbyId(@PathVariable int managerId)
	{
		managerservice.deleteManagerbyId(managerId);
	}
}
