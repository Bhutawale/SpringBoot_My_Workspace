package com.scm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.UserDao;
import com.scm.entities.User;

@Service
public class UserService 
{
	@Autowired
	public UserDao dao;
	
	public User saveUser(User user)
	{
		User u = dao.save(user);
		return u;
	}
}
