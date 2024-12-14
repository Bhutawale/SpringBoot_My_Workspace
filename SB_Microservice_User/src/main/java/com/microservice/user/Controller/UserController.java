package com.microservice.user.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.Entity.User;
import com.microservice.user.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user,BindingResult result)
	{
		try 
		{
			Map<User, String> map=new HashMap<User, String>();
		
			if(!result.hasErrors())
			{
				User saveUser = service.saveUser(user);
				map.put(saveUser, "User Saved Successfully!!");
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
			else
			{
				List<String> errors = result.getAllErrors()
				.stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errors);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong!! Please Try Again.");
		}
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers()
	{
		try
		{
			List<User> allUsers = service.getAllUsers();
			if(!allUsers.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(allUsers);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Users Found!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! Please try again.");
		}
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id)
	{
		try
		{
			
			User userById = service.getUserById(id);
		
			if(userById!=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body(userById);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("User with given id "+id+" Not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went wrong!!");
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable int id)
	{
		try
		{
			Map<String,User> map=new HashMap<>();
			User userById = service.getUserById(id);
			System.out.println(userById);
			if(userById.getId()==id)
			{
				userById.setName(user.getName());
				
				User updatedUser = service.updateUser(userById, id);
				map.put("User Updated Successfully.",updatedUser);
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("User Not Found to update!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went Wrong!!");
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id)
	{
		try
		{
			User userById = service.getUserById(id);
			if(userById!=null)
			{
				service.deleteUser(id);
				return ResponseEntity.status(HttpStatus.OK).body("User with id "+id+" deleted Successfully.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id "+id+" not Found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
		}
	}
}
