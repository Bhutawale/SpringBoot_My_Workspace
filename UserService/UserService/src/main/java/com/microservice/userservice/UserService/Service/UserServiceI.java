package com.microservice.userservice.UserService.Service;

import java.util.List;

import com.microservice.userservice.UserService.Entity.User;


public interface UserServiceI 
{
	public User addUser(User user);
	
	public User getUser(int uid);
	
	public List<User> getAllUser();
	
	public void deleteUser(int uid);
	
	public User updateUser(User user);
}
