package com.example.restaurant_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Customer;
import com.example.restaurant_management.model.Customer_Rating;
import com.example.restaurant_management.model.Sell;

@Repository
public interface AdminDaoI extends JpaRepository<Admin, Integer>
{
	@Query("select s from Sell s where sellId=?1")
	public List<Sell> findAllSellById(int sellId);
	
	@Query("select r from Customer_Rating r where r.ratingId IN(select c.rating from Customer c where c.customerId=?1) ")
	public List<Customer_Rating> findAllRatingById(int customerId);
	
	@Query("select s from Sell s where s.sellDate=?1")
	public List<Sell> findAllSellByDate(String sellDate);
}
