package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Admin;
import com.example.demo.Service.AdminServiceI;
@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminServiceI as;
     @PostMapping("/add")
     public String addAdmin(@RequestBody Admin admin)
     {
    	 as.addAdmin(admin);
    	 return "Data Successfully Added";
     }
     @GetMapping("/edit/{id}")
     public Admin add(@PathVariable int id)
     {
    	  Admin a=as.editAdmin(id);
    	  return a;
     }
     @PutMapping("/update")
     public Admin updateAdmin(@RequestBody Admin admin)
     {
    	 Admin a1=as.updateAdmin(admin);
    	 return a1;
     }
     @DeleteMapping("/delete/{id}")
     public void deleteAdmin(@PathVariable int id)
     {
    	as.deleteAdmin(id) ;
     }
}
