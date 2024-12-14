package com.example.restaurant_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_management.model.Product;
import com.example.restaurant_management.service.OrderServiceI;

@RestController
@RequestMapping("Order")
public class OrderController
{
	@Autowired
	private OrderServiceI orderservice;
	
	@GetMapping("/findAllProductsByOrderId/{orderId}")
	public ResponseEntity<List<Product>> findAllProductByOrderId(@Valid @PathVariable int orderId)
	{
		List<Product> findAllProductByOrderId = orderservice.findAllProductByOrderId(orderId);
		
		if(findAllProductByOrderId.isEmpty())
		{
			System.out.println("Record Not Found of given Order Id");
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		else
		{
			System.out.println("Record Found of given Order Id");
			return new ResponseEntity<List<Product>>(findAllProductByOrderId,HttpStatus.OK);
		}
						
	}
}
