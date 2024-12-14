package com.example.furniture_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.furniture_management.dao.UserDaoI;
import com.example.furniture_management.model.Feedback;
import com.example.furniture_management.model.User;

@Service

public class UserServiceImpl implements UserServiceI
{
	@Autowired
	private UserDaoI userdao;
	
	public User addUser(User user)
	{	
		return userdao.save(user);
	}

	public List<User> showUser() 
	{
		return userdao.findAll() ;
	}

	public Optional<User> showUserbyId(int userId) 
	{
		return userdao.findById(userId);
	}

	public User updateUser(User user) 
	{
		return userdao.save(user);
	}

	public void deleteUser(int userId) 
	{
		userdao.deleteById(userId);
	}
	
	public long countUser()
	{
		return userdao.count();
	}

	public List<User> showuserbycity(String userCity) 
	{
		return userdao.findByUserCity(userCity);
	}

	public List<User> showuserbygender(String userGender) 
	{
		List<User> findByUserGender = userdao.findByUserGender(userGender);
		return findByUserGender;
	
	}
	
	public List<User> showuserbyusernameanduserid(String userName, int userId) 
	{	
		return userdao.findByUserNameAndUserId(userName, userId);
	}

	public List<User> showuserbyusernameandloginid( int loginId,String userName) 
	{
		return userdao.findByUserNameAndLoginId(loginId, userName);
	}

	
	public List<User> showusersortedbyusername()
	{
		return userdao.findAllSortedByUserName();
	}

	public List<User> showuserproductbyusername(int userId)
	{
		return userdao.findAllproductOrderedByUserName(userId);
	}

	
	public List<Feedback> showuserfeedback(int userId) 
	{
		return userdao.findByFeedbackGivenByUser(userId);
	}

		
	
} 
