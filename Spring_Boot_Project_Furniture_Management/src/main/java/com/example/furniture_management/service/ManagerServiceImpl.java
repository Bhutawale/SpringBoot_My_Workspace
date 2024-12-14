package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture_management.dao.ManagerDaoI;
import com.example.furniture_management.model.Manager;

@Service
public class ManagerServiceImpl implements ManagerServiceI 
{
	@Autowired
	private ManagerDaoI managerdao;
	
	public Manager addManager(Manager manager)
	{
		return managerdao.save(manager);		
	}

	public List<Manager> showallManager() 
	{
		return managerdao.findAll();
	}

	public Optional<Manager> showManagerbyId(int managerId) 
	{
		return managerdao.findById(managerId);
	}

	public Manager updateManager(Manager manager) 
	{	
		return managerdao.save(manager);
	}

	public void deleteManagerbyId(int managerId) 
	{
		managerdao.deleteById(managerId);
	}
	
}
