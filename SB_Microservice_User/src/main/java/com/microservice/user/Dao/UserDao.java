package com.microservice.user.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.user.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> 
{
	
}
