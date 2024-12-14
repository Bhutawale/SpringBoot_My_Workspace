package com.example.demo.Service;

import com.example.demo.Model.Admin;

public interface AdminServiceI {

	public void addAdmin(Admin admin);

	public Admin editAdmin(int id);

	public Admin updateAdmin(Admin admin);

	public void deleteAdmin(int id);

	

}
