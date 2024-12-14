package com.example.restaurant_management.service;

import java.util.List;

import com.example.restaurant_management.model.Product;

public interface OrderServiceI 
{
	public List<Product> findAllProductByOrderId(int orderId);

}
