package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.scm.dao.UserDao;
import com.scm.entities.User;


public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User userByUserEmail = dao.getUserByUserEmail(username);
		if(userByUserEmail==null)
		{
			throw new UsernameNotFoundException("Not Found User");
		}
		CustomUserDetails customUserDetails=new CustomUserDetails(userByUserEmail);
		
		return customUserDetails;
	}
	
}
