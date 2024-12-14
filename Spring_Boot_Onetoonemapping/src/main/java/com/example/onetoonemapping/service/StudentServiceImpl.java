package com.example.onetoonemapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetoonemapping.dao.StudentDaoI;
import com.example.onetoonemapping.model.Student;

@Service
public class StudentServiceImpl implements StudentServiceI
{
	@Autowired
	private StudentDaoI d;
	
	public void addStudent(Student stu) 
	{
		d.save(stu);		
	}
	
}
