package com.example.restaurant_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.restaurant_management.model.Admin;
import com.example.restaurant_management.model.Bill;
import com.example.restaurant_management.model.Ratings;

@Repository
public interface AdminDaoI extends JpaRepository<Admin, Integer>
{
	
	@Query("select r from Ratings r where r.customer IN(select c.customerId from Customer c where customerId=?1)")
	public Ratings findAllRatingsByCustomerId(int customerId);

	@Query("select b from Bill b where b.billId IN(select c.bill from Customer c where customerName=?1)")
	public List<Bill> findAllBillByCustomerName(String customerName);
	
	@Query("select b from Bill b where b.billDate=?1")
	public List<Bill> findAllBillByDate(String billDate);
}