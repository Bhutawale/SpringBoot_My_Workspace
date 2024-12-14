package com.example.restaurant_management.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.restaurant_management.model.Bill;

@Repository
public interface BillDaoI extends JpaRepository<Bill, Integer> 
{
	
}
