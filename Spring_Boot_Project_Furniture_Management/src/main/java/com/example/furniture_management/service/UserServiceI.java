package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import com.example.furniture_management.model.Feedback;
import com.example.furniture_management.model.User;


public interface UserServiceI
{
	public User addUser(User user);
	
	public List<User> showUser();
	
	public Optional<User> showUserbyId(int userId);
	
	public User updateUser(User user);
	
	public void deleteUser(int userId);
	
	public long countUser();
	
	public List<User> showuserbycity(String userCity);
	
	public List<User> showuserbygender(String userGender);
	
	public List<User> showuserbyusernameanduserid
	(String userName,int userId);
	
	public List<User> showuserbyusernameandloginid
	(int loginId,String userName);
	
	public List<User> showusersortedbyusername();
	
	public List<User> showuserproductbyusername(int userId);
	
	public List<Feedback> showuserfeedback(int userId);
		
}
