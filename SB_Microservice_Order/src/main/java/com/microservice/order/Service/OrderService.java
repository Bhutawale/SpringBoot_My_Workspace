package com.microservice.order.Service;

import java.util.List;

import com.microservice.order.Entity.Order;

public interface OrderService 
{
	public Order SaveOrder(Order order);
	
	public void delteOrder(int id);
	
	public Order getOrderById(int id);
	
	public List<Order> getAllOrders();
	
	public Order UpdateOrder(Order order,int id);
	
	public List<Order> getOrderByUid(int id);
}
