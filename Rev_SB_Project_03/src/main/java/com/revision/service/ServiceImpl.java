package com.revision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revision.dao.StudentDao;
import com.revision.entities.Student;
import com.revision.exception.StudentNotFoundException;

@Service
public class ServiceImpl implements ServiceI
{
	@Autowired
	private StudentDao studentrepo;

	public Student saveStudent(Student student) 
	{
		Student savedStudent = studentrepo.save(student);
		return savedStudent;
	}

	
	public Student findStudentById(int sId) 
	{
		Student studentById = studentrepo.findById(sId)
				.orElseThrow(()->new StudentNotFoundException("Student with given Id "+sId +" Not found."));
		return studentById;
	}

	public List<Student> findAllStudents() 
	{
		List<Student> allStudents = studentrepo.findAll();
		return allStudents;
	}

	public void deleteStudentById(int sId) 
	{
		studentrepo.findById(sId)
				.orElseThrow(()->new StudentNotFoundException("Student with given Id "+sId +" Not found."));
			
		studentrepo.deleteById(sId);
	}

	public Student updateStudent(Student student, int sId) 
	{
		Student existingStudent = studentrepo.findById(sId)
				.orElseThrow(()->new StudentNotFoundException("Student with given Id "+sId +" Not found.") );
		
		if(existingStudent.getSid()==sId)
		{
			existingStudent.setName(student.getName());
			existingStudent.setAge(student.getAge());
			existingStudent.setGender(student.getGender());
			existingStudent.setAddress(student.getAddress());
			existingStudent.setCourse(student.getCourse());
		}
		
		Student updatedStudent = studentrepo.save(existingStudent);
		
		return updatedStudent;
	}


	public Student findStudentByName(String name) 
	{
		Student studentByName = studentrepo.findStudentByName(name);
		if(studentByName==null)
		{
			throw new StudentNotFoundException("Student with given name "+name +" Not Found");
		}
		else
		{
			return studentByName;
		}
	}
	
}
