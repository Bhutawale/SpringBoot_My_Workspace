package com.microservice.order.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.order.Dao.OrderDao;
import com.microservice.order.Entity.Order;

@Service
public class OrderServiceImpl implements OrderService 
{
	@Autowired
	private OrderDao dao;

	@Override
	public Order SaveOrder(Order order) 
	{	
		Order saveOrder = dao.save(order);
		return saveOrder;
	}

	@Override
	public void delteOrder(int id) 
	{
		dao.deleteById(id);
	}

	@Override
	public Order getOrderById(int id) 
	{
		Order orderById = dao.findById(id).orElse(null);
		return orderById;
	}

	@Override
	public List<Order> getAllOrders() 
	{
		List<Order> allOrders = dao.findAll();
		return allOrders;
	}

	@Override
	public Order UpdateOrder(Order order,int id) 
	{
		Order orderbyid = dao.findById(id).get();
		if(orderbyid.getOrder_id()==id)
		{
			Order updatedOrder = dao.save(order);
			return updatedOrder;
		}
		else
		{
			return null;
		}
		
	}
	
	public List<Order> getOrderByUid(int id)
	{
		List<Order> findOrderByUid = dao.findOrderByUid(id);
		if(!findOrderByUid.isEmpty())
		{
			return findOrderByUid;
		}
		else
		{
			return null;
		}
	}
	
}
