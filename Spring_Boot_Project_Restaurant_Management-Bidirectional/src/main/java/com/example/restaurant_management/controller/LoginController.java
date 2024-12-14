package com.example.restaurant_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_management.model.Login;
import com.example.restaurant_management.service.LoginServiceI;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	private LoginServiceI loginservice;
	
	@PostMapping("/findbyloginnameandpassword/{loginName}/{loginPassword}")
	public ResponseEntity<List<Login>> findByLoginNameAndLoginPassword
	(@PathVariable String loginName,@PathVariable String loginPassword)
	{
		List<Login> findByLoginNameAndLoginPassword = loginservice.findByLoginNameAndLoginPassword(loginName, loginPassword);
		return new ResponseEntity<List<Login>>(findByLoginNameAndLoginPassword,HttpStatus.OK);
		
	}
}
