package com.microservice.order.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.Entity.Order;
import com.microservice.order.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService service;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@Valid @RequestBody Order order,BindingResult result)
	{
		Map<String, Order> map=new HashMap<String, Order>();
		try 
		{
			if(!result.hasErrors())
			{
				Order saveOrder = service.SaveOrder(order);
				map.put("Order Saved Successfully.", saveOrder);
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
			else
			{
				List<String> errors = result.getAllErrors()
						.stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong!!");
		}
	}
	
	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable int id)
	{
		try
		{
			
			Order orderById = service.getOrderById(id);
			
			if(orderById!=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body(orderById);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body("Order with given id "+ id+ " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
		}
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders()
	{
		try
		{
			List<Order> allOrders = service.getAllOrders();
			if(!allOrders.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(allOrders);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body("No Orders placed yet by any user!!.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
		}
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int id)
	{
		try
		{
			Order orderById = service.getOrderById(id);
			if(orderById!=null)
			{
				service.delteOrder(id);
				return ResponseEntity.status(HttpStatus.OK).body("Order with id "+id+" deleted Successfully.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with id "+id+" not Found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");

		}
	}
	
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody Order order,@PathVariable int id)
	{
		try
		{
			Map<String, Order> map=new HashMap<>();
			Order orderById = service.getOrderById(id);
			if(orderById.getOrder_id()==id)
			{
				orderById.setOrder_name(order.getOrder_name());
				orderById.setOrder_quantity(order.getOrder_quantity());
				orderById.setUid(order.getUid());
				
				Order updateOrder = service.UpdateOrder(orderById, id);
				map.put("Order Updated Successfully.", updateOrder);
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Order Not Found to update!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went Wrong!!");
		}
	}
	
	@GetMapping("/getOrderByUid/{id}")
	public ResponseEntity<?> getOrdersByUid(@PathVariable int id)
	{
		try 
		{
			List<Order> orderByUid = service.getOrderByUid(id);
			if(!orderByUid.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(orderByUid);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Order found for user!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
		}
	}
}
