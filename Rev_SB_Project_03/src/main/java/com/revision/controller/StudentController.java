package com.revision.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revision.entities.Student;
import com.revision.exception.ExceptionResponse;
import com.revision.service.ServiceI;

@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private ServiceI studentservice;

	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student,BindingResult result)
	{
		if(result.hasErrors())
		{
			List<String> errors = result.getAllErrors().stream()
			.map(error->error.getDefaultMessage())
			.collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		else
		{
			Student saveStudent = studentservice.saveStudent(student);
			return ResponseEntity.status(HttpStatus.OK).body(saveStudent);
		}
		
	}
	
	@GetMapping("/findStudentById/{sId}")
	public ResponseEntity<?> findStudentById(@PathVariable("sId")int sId)
	{
		Student studentById = studentservice.findStudentById(sId);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentById);
		
	}
	
	@GetMapping("/findAllStudents")
	public ResponseEntity<?> findAllStudents()
	{
		List<Student> allStudents = studentservice.findAllStudents();
		if(!allStudents.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(allStudents);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ExceptionResponse("Database is Empty.No Students found.",new Date()));
		}
	}
	
	@DeleteMapping("/deleteStudentById/{sId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("sId") int sId)
	{
		studentservice.deleteStudentById(sId);
		
		return ResponseEntity.status(HttpStatus.OK).body("Student with given Id "+sId+" deleted successfully.");
		
	}
	
	@PutMapping("/updateStudent/{sId}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable("sId") int sId)
	{
		studentservice.updateStudent(student, sId);
		
		return ResponseEntity.status(HttpStatus.OK).body("Student Updated Successfully.");
		
	}
	
	@GetMapping("/findStudentByName/{name}")
	public ResponseEntity<?> findStudentByName(@PathVariable("name") String name)
	{
		Student studentByName = studentservice.findStudentByName(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentByName);
	}
}
