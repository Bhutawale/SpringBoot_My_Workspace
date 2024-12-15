package com.microservice.branch.service;

import java.util.List;

import com.microservice.branch.entity.Branches;

public interface BranchServiceI 
{
	public Branches saveBranch(Branches branch);
	
	public void deleteBranch(int id);
	
	public Branches getBranchById(int id);
	
	public List<Branches> getAllBranches();
	
	public Branches updateBranch(Branches branch, int id);
	
	public List<Branches> getBranchByCompanyId(int cid);
}
