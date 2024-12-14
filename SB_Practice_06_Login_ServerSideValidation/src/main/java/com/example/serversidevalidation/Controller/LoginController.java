package com.example.serversidevalidation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.serversidevalidation.Model.LoginData;

@Controller
public class LoginController 
{
	@GetMapping("/form")
	public String form(Model model)
	{
		model.addAttribute("loginData",new LoginData());
		return "loginForm";
	}
	
	@PostMapping("/submitForm")
	public String submitForm(@ModelAttribute("loginData") LoginData LoginData)
	{
		System.out.println(LoginData);
		return "success";
	}
}
