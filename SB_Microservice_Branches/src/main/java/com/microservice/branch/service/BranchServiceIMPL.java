package com.microservice.branch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.branch.dao.BranchDao;
import com.microservice.branch.entity.Branches;

@Service
public class BranchServiceIMPL implements BranchServiceI 
{

	@Autowired
	private BranchDao branchdao;
	
	@Override
	public Branches saveBranch(Branches branch) 
	{
		Branches savebranch = branchdao.save(branch);
		return savebranch;
	}

	@Override
	public void deleteBranch(int id) 
	{
		Optional<Branches> branchById = branchdao.findById(id);
		if(branchById.isPresent())
		{
			branchdao.deleteById(branchById.get().getId());
		}
		
	}

	@Override
	public Branches getBranchById(int id)
	{
		Optional<Branches> branchById = branchdao.findById(id);
		if(branchById.isPresent())
		{
			return branchById.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Branches> getAllBranches() 
	{
		List<Branches> findAllBranches = branchdao.findAll();
			return findAllBranches;
		
	}

	@Override
	public Branches updateBranch(Branches branch, int id) 
	{
		Optional<Branches> existingBranch = branchdao.findById(id);
		if(existingBranch.isPresent() && existingBranch!=null)
		{
			Branches branchToUpdate = existingBranch.get();
			
			branchToUpdate.setCity(branch.getCity());
			
			Branches updatedBranch = branchdao.save(branchToUpdate);
			
			return updatedBranch;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Branches> getBranchByCompanyId(int cid) 
	{
		List<Branches> branchByCompanyId = branchdao.getBranchByCompanyId(cid);
		return branchByCompanyId;
	}
	
}
