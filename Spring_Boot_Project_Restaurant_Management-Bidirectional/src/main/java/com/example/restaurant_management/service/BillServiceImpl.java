package com.example.restaurant_management.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant_management.dao.BillDaoI;
import com.example.restaurant_management.model.Bill;

@Service
public class BillServiceImpl implements BillServiceI
{	
	@Autowired
	private BillDaoI billdao;
	
	public Bill updateBill(Bill bill) 
	{
		return billdao.save(bill);
	}


	
	
}
