package com.microservice.branch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.branch.entity.Branches;

@Repository
public interface BranchDao extends JpaRepository<Branches, Integer>
{
	@Query("select b from Branches b where b.cid=:cid")
	public List<Branches> getBranchByCompanyId(@Param("cid") int cid); 
}
