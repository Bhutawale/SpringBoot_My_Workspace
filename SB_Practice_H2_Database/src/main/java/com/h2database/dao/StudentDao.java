package com.h2database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h2database.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> 
{
	
}
