package com.basicproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basicproject.Entity.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@GetMapping("/displayform")
	public String displayUserform()
	{
		return "displayform";
	}

	@PostMapping("/displayuser")
	public String displayUserData(@ModelAttribute User user,Model model)
	{
		if(user.getName().isEmpty() || user.getEmail().isEmpty())
		{
			model.addAttribute("user", new User());
			return "displayform";
		}
		else
		{
			return "displayuser";
		}
	}
}
