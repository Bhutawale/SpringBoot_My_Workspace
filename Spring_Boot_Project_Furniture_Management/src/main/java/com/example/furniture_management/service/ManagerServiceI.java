package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import com.example.furniture_management.model.Manager;

public interface ManagerServiceI 
{
	public Manager addManager(Manager manager);
	
	public List<Manager> showallManager();
	
	public Optional<Manager> showManagerbyId(int managerId);
	
	public Manager updateManager(Manager manager);
	
	public void deleteManagerbyId(int managerId);
}
