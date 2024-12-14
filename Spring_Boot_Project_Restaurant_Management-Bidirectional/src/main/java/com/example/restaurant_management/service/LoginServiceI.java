package com.example.restaurant_management.service;

import java.util.List;

import com.example.restaurant_management.model.Login;

public interface LoginServiceI 
{
	public List<Login> findByLoginNameAndLoginPassword
	(String loginName,String loginPassword);
}
