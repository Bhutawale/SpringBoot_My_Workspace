package com.revision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revision.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	public Employee findByName(String name);
	
	public List<Employee> findByAddress_City(String city);
	
	@Query(value = "SELECT e.* FROM Employee e INNER JOIN Address a ON e.address_id = a.id WHERE e.name = :name AND a.city = :city"
			,nativeQuery = true)
	public List<Employee> findBYNameAndCity(@Param("name")String name,@Param("city")String city);
} 
