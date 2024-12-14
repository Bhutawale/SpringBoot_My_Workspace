package com.microservice.userservice.UserService.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userservice.UserService.Dao.UserDao;
import com.microservice.userservice.UserService.Entity.Rating;
import com.microservice.userservice.UserService.Entity.User;

@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private RestTemplate resttemplate; //for calling rating service API from user service
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	
	
	public User addUser(User user) 
	{
		return userdao.save(user);			
	}


	public User getUser(int uid) 
	{
		User findById = userdao.findById(uid).orElseThrow(()->new RuntimeException("User Not Found"));
		
		//fetch rating from the Rating MicroService.
		//http://localhost:1113/rating/getRatingByUserId/1
		ArrayList<Rating> userratings = resttemplate.getForObject("http://localhost:1113/rating/getRatingByUserId/"+findById.getUid(), ArrayList.class);
		
		logger.info("{} ",userratings);
		
		findById.setUrating(userratings);
		
		return findById;
		
	}


	public List<User> getAllUser() {
		 List<User> findAll = userdao.findAll();
		 
		 ArrayList<Rating> userallratings = resttemplate.getForObject("http://localhost:1113/rating/getAllRatings", ArrayList.class);
		 
		 logger.info("{} ",userallratings);
		 
		 System.out.println(userallratings);
		 
		 for(User u:findAll)
		 {
			 u.setUrating(userallratings);
		 }
		  
		 return findAll;
	}


	public void deleteUser(int uid) {
		userdao.deleteById(uid);
	}

	public User updateUser(User user) {
		
		return userdao.save(user);
	}


	
}

