package com.example.onetoonemapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoonemapping.model.Student;

@Repository
public interface StudentDaoI extends JpaRepository<Student, Integer>
{

}
