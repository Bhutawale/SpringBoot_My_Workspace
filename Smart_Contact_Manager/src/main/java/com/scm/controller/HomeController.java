package com.scm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.helper.Message;
import com.scm.service.UserService;


@Controller
@RequestMapping("/ContactManager")
public class HomeController 
{
	@Autowired
	private UserService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("title", "Contact Manager Project");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult res,
			@RequestParam(value = "condition",defaultValue = "false")boolean condition,
			HttpSession session,Model model)
	{
		try {
			if(res.hasErrors())
			{
				model.addAttribute("user",user);
				return "signup";
			}
			if(!condition)
			{
				System.out.println("Agree Terms and Conditions first!!");
				session.setAttribute("message", new Message("Agree to the terms and Conditions!!", "alert-danger"));
				model.addAttribute("user", user); 
				return "signup";
			}
			else
			{
				user.setEnabled(true);
				user.setRole("ROLE_USER");
				user.setImageUrl("default.png");
				user.setPassword(encoder.encode(user.getPassword()));
				service.saveUser(user);
				session.setAttribute("message", new Message("User Saved Successfully!!", "alert-success"));
				 model.addAttribute("user", new User());
				return "signup";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went Wrong!!", "alert-danger"));
			model.addAttribute("user", user);
			return "signup";
		}
	}
}
