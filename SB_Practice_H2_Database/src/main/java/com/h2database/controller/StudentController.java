package com.h2database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2database.entity.Student;
import com.h2database.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(Student student)
	{
		Student saveStudent = service.saveStudent(student);
		return saveStudent;
	}
}
