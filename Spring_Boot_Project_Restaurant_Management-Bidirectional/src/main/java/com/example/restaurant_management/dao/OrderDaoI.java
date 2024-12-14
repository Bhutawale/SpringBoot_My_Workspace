package com.example.restaurant_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.restaurant_management.model.Order;
import com.example.restaurant_management.model.Product;
@Repository
public interface OrderDaoI extends JpaRepository<Order, Integer>
{
	@Query("select p from Product p where p.order IN(select o.orderId from Order o where orderId=?1)")
	public List<Product> findAllProductByOrderId(int orderId);
	
}
