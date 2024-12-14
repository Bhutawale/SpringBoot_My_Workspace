package com.example.employeeproject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employeeproject.Entity.Employee;

@Repository
public interface Employee_Dao extends JpaRepository<Employee, Integer>
{
	@Query(value =  "Select * from employee where city=?", nativeQuery = true)
	public List<Employee> getEmpByCity(String City);
	
	@Query("SELECT e FROM Employee e WHERE e.company_name=?1 AND e.city=?2")
	public List<Employee> getEmpByCompanyNameAndCity(String company,String city);
	
	@Query(value = "select * from employee where salary>=?1",nativeQuery = true)
	public List<Employee> getEmpSalaryGreaterThan(int salary);
	
	@Query("SELECT e from Employee e WHERE e.name LIKE ?1%")
	public List<Employee> getEmpNameStartWithLetter(String letter);
	
	@Query(value = "SELECT e.* FROM employee e JOIN experience ex ON e.id = ex.id WHERE ex.exp1=?1 OR ex.exp2 = ?1",nativeQuery = true)
	public List<Employee> getEmpExpByCompanyName(String company);
}
