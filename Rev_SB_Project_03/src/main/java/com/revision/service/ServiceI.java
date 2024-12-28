package com.revision.service;

import java.util.List;

import com.revision.entities.Student;


public interface ServiceI 
{
	public Student saveStudent(Student student);
	
	public Student findStudentById(int sId);
	
	public List<Student> findAllStudents();
	
	public void deleteStudentById(int sId);
	
	public Student updateStudent(Student student,int sId);
	
	public Student findStudentByName(String name);
}
