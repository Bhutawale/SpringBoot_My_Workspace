package com.microservice.user.Service;

import java.util.List;

import com.microservice.user.Entity.User;

public interface UserService
{
	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User updateUser(User user,int id);
	
	public void deleteUser(int id);
}
