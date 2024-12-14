package com.example.restaurant_management.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant_management.model.Login;
@Repository
public interface LoginDaoI extends CrudRepository<Login, Integer> 
{
	public List<Login> findByLoginNameAndLoginPassword
		(String loginName,String loginPassword);
}
