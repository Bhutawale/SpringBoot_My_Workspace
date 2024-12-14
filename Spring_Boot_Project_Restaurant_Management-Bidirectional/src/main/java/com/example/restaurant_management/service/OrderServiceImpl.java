package com.example.restaurant_management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restaurant_management.dao.OrderDaoI;
import com.example.restaurant_management.model.Product;

@Service
public class OrderServiceImpl implements OrderServiceI
{
	@Autowired
	private OrderDaoI orderdao;
	
	public List<Product> findAllProductByOrderId(int orderId) 
	{
		return orderdao.findAllProductByOrderId(orderId);
	}
}