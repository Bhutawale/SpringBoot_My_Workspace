package com.microservice.user.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.Dao.UserDao;
import com.microservice.user.Entity.Order;
import com.microservice.user.Entity.User;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDao dao;
	
	@Autowired
	private RestTemplate resttemplate;
	
	
	public User saveUser(User user) 
	{
		return dao.save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() 
	{
		List<User> allUsers = dao.findAll();
		
		for(User u:allUsers)
		{
			try
			{
				
				//using Resttemplate for service communication 
				
				ArrayList<Order> orderforeachuser = resttemplate.
						getForObject("http://localhost:2122/order/getOrderByUid/" + u.getId(),
		            ArrayList.class);
				if(orderforeachuser==null || orderforeachuser.isEmpty())
				{
					u.setOrder(Collections.emptyList());
				}
				else
				{
					u.setOrder(orderforeachuser);
				}
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return allUsers;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserById(int id) {
		
		
		    // Fetch user by ID
		    User userById = dao.findById(id).orElse(null);
		    
		    System.out.println(userById);
//		    
//		    String rawResponse = resttemplate.getForObject(
//		    	    "http://localhost:2122/order/getOrderByUid/" + userById.getId(),
//		    	    String.class
//		    	);
//		    	System.out.println("Raw API Response: " + rawResponse);
//
//		    	
		    if(userById==null) {
		    	return null;
		    }
		    
		    try {
		        // Fetch the response as a List<Order>
		        
				ArrayList<Order> orders = resttemplate.getForObject(
		            "http://localhost:2122/order/getOrderByUid/" + userById.getId(),
		            ArrayList.class
		        );
		        	
		        System.out.println(orders);
		        
		        if (orders == null || orders.isEmpty()) {
		            // Set an empty list if no orders are found
		            userById.setOrder(Collections.emptyList());
		        } else {
		            // Set orders to the user
		            userById.setOrder(orders);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to fetch orders for user with ID: " + id, e);
		    }

		    return userById;
		}
	
	
	public User updateUser(User user,int id)
	{
		return dao.save(user);
	}

	public void deleteUser(int id)
	{
		dao.deleteById(id);
	}
	
}
