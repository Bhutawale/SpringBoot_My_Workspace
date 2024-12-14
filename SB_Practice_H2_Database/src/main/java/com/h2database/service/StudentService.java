package com.h2database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2database.dao.StudentDao;
import com.h2database.entity.Student;

@Service
public class StudentService
{
	@Autowired
	private StudentDao studentDao;
	
	public Student saveStudent(Student student)
	{
		Student saveStudent = studentDao.save(student);
		return saveStudent;
	}
}
