package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.AdminDaoI;
import com.example.demo.Model.Admin;

@Service
public class AdminServiceImpl implements AdminServiceI
{
    @Autowired
    private AdminDaoI ad;
	@Override
	public void addAdmin(Admin admin) 
	{
		ad.save(admin);
	}
    @Override
	public Admin editAdmin(int id) 
	{
     Admin a=ad.findById(id).get();
    return a ;
	}
    @Override
	public Admin updateAdmin(Admin admin) 
    {
    	Admin a1=ad.save(admin);
    	return a1;
    }
    @Override
	public void deleteAdmin(int id) 
	{
    	ad.deleteById(id);
	}
}
