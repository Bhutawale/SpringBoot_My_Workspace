package com.microservice.order.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.microservice.order.Entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>
{
	@Query("select o from Order o where o.uid=?1")
	public List<Order> findOrderByUid(int uid); 
}
