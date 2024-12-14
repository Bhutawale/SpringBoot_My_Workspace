package com.example.restaurant_management.controller;




import javax.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_management.model.Bill;
import com.example.restaurant_management.service.BillServiceI;

@RestController
@RequestMapping("/bill")
public class BillController
{
	private BillServiceI billservice;
	
	@PutMapping("/updatBill")
	public Bill updateBill(@Valid @RequestBody Bill bill)
	{
		return billservice.updateBill(bill);
	}
	
}
