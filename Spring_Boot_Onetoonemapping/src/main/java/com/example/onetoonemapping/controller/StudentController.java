package com.example.onetoonemapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetoonemapping.model.Student;
import com.example.onetoonemapping.service.StudentServiceI;

@RestController
@RequestMapping("/Student")
public class StudentController 
{
	@Autowired
	private StudentServiceI s;
	
	@PostMapping("/addStudent")
	public void add(@RequestBody Student stu)
	{
		s.addStudent(stu);
	}
}
