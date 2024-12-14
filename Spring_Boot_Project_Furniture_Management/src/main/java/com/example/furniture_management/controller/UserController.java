package com.example.furniture_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture_management.model.Feedback;
import com.example.furniture_management.model.User;
import com.example.furniture_management.service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserServiceI userservice;
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return userservice.addUser(user);
		
	}
	
	@GetMapping("/showuser")
	public List<User> showUser()
	{
		return userservice.showUser();
	}
	
	@GetMapping("/showuserbyid/{userId}")
	public Optional<User> showUserbyId(@PathVariable int userId)
	{ 
		return userservice.showUserbyId(userId);
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user)
	{
		return userservice.updateUser(user);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public void deleteUser(@PathVariable int userId)
	{
		userservice.deleteUser(userId);
	}
	
	@GetMapping("/countusers")
	public long countUser()
	{
		return userservice.countUser();
	}
	
	@GetMapping("/finduserbycity/{userCity}")
	public List<User> findByUserCity(@PathVariable String userCity)
	{
		return userservice.showuserbycity(userCity);		
	}
	
	@GetMapping("/finduserbygender/{userGender}")
	public List<User> findByUserGender(@PathVariable String userGender)
	{
		return userservice.showuserbygender(userGender);
		
	}
	
	@GetMapping("/finduserbyusernameanduserid/{userName}/{userId}")
	public List<User> findByUserNameAndUserId
	(@PathVariable String userName,@PathVariable int userId)
	{
		return userservice.showuserbyusernameanduserid(userName, userId);
	}
	
	@GetMapping("/finduserbyusernameandloginid/{loginId}/{userName}")
	public List<User> findByUserNameAndLoginId
	(@PathVariable int loginId,@PathVariable String userName)
	{
		return userservice.showuserbyusernameandloginid(loginId, userName);
	}
	
	@GetMapping("/usersortedbyusername")
	public List<User> findAllSortedByUserName()
	{
		return userservice.showusersortedbyusername();
	}
	
	@GetMapping("/userorderedproducts/{userId}")
	public List<User> findAllProductOrderedByUserName(@PathVariable int userId)
	{
		return userservice.showuserproductbyusername(userId);
	}
	
	@GetMapping("/showuserfeedback/{userId}")
	public List<Feedback> findAllFeedbackGivenByUser(@PathVariable int userId)
	{
		return userservice.showuserfeedback(userId);
	}
}
