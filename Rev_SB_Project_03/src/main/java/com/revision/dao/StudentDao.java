package com.revision.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revision.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> 
{
	@Query(value = "select * from Student s where s.name=:name",nativeQuery = true)
	public Student findStudentByName(@Param("name")String name);
}
