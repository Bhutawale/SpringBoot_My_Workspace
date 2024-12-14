package com.example.restaurant_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant_management.dao.LoginDaoI;
import com.example.restaurant_management.model.Login;

@Service
public class LoginServiceImpl implements LoginServiceI
{
	@Autowired
	private LoginDaoI logindao;
	
	public List<Login> findByLoginNameAndLoginPassword
	(String loginName, String loginPassword) 
	{ 
		Optional<Login> findById = logindao.findById(1);
		
		Login login = findById.get();
		
		String loginname = login.getLoginName();
		
		String loginpassword = login.getLoginPassword();
		
		if(loginname.equals(loginName) && 
				loginpassword.equals(loginPassword))
		{
			System.out.println("Login Details are Correct and Admin login successfully.");
			return logindao.findByLoginNameAndLoginPassword(loginname, loginpassword);
		}
		else
		{
			System.out.println("Enter correct login details");
			return null;
		}
		
	
	}

}
