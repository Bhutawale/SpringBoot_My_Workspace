package com.scm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.dao.UserDao;
import com.scm.entities.Contacts;
import com.scm.entities.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserDao dao;
	
	@ModelAttribute
	public void commonUserData(Model model,Principal principal)
	{
		String name = principal.getName();
		
		System.out.println(name);
		
		User user = dao.getUserByUserEmail(name);
		
		System.out.println(user);
		
		model.addAttribute("user", user);
	
	}
	
	@RequestMapping("/index")
	public String dashboard(Model model)
	{	
		model.addAttribute("title", "User DashBoard");
		return "normal_user/user_dashboard";
	}
	
	@GetMapping("/addcontact")
	public String addContact(Model model)
	{
		model.addAttribute("title", "Add Contacts Page");
		model.addAttribute("contact", new Contacts());
		return "normal_user/addcontact";
	}
	
	@PostMapping("/process_contact")
	public String processcontact(@ModelAttribute Contacts contact,Principal principal)
	{
		
		
		System.out.println(contact);
		String name = principal.getName();
		
		User user = dao.getUserByUserEmail(name);
		
		contact.setUser(user);
		
		user.getContacts().add(contact);
		
		dao.save(user);

		
		return "normal_user/addcontact";
	}
	
}

