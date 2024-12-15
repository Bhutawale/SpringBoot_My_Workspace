package com.microservice.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.company.entity.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> 
{
	@Query("select c from Company c where c.eid=:eid")
	public List<Company> getCompanyByEmployeeId(@Param("eid") int eid);
}
