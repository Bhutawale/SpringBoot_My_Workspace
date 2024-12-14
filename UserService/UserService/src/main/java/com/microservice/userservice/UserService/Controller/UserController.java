package com.microservice.userservice.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.UserService.Entity.User;
import com.microservice.userservice.UserService.Service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserServiceI userservice;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
		return userservice.addUser(user);
	}
	
	@GetMapping("/getUserById/{uid}")
	public User getUser(@PathVariable int uid)
	{
		User user = userservice.getUser(uid);
		return user;
		
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser()
	{
		return userservice.getAllUser();
	}
	
	@DeleteMapping("/deleteUserById/{uid}")
	public void deleteUser(@PathVariable int uid)
	{
		userservice.deleteUser(uid);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user)
	{
		return userservice.updateUser(user);
	}
	
}
