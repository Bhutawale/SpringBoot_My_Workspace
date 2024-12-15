package com.microservice.branch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.branch.entity.Branches;
import com.microservice.branch.service.BranchServiceI;

@RestController
@RequestMapping("/branch")
public class BranchController
{
	@Autowired
	private BranchServiceI branchservice;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<?> saveBranch(@RequestBody Branches branch)
	{
		try
		{
			branchservice.saveBranch(branch);
			return ResponseEntity.status(HttpStatus.OK).body("Branch saved successfully.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
	
	@DeleteMapping("/deleteBranch/{id}")
	public ResponseEntity<?> deleteBranch(@PathVariable int id)
	{
		try
		{
			Branches branchById = branchservice.getBranchById(id);
			if(branchById!=null)
			{
				branchservice.deleteBranch(id);
				return ResponseEntity.status(HttpStatus.OK).body("Branch with Id "+ id+" deleted successfully.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body("Branch with Id "+ id+" Not found so not deleted."); 
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
	
	@GetMapping("/getBranchById/{id}")
	public ResponseEntity<?> getBranchById(@PathVariable int id)
	{
		try
		{
			Branches branchById = branchservice.getBranchById(id);
			if(branchById!=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body(branchById);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body("Branch with Id "+ id+" Not found."); 
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
	
	@GetMapping("/getAllBranches")
	public ResponseEntity<?> getAllBranches()
	{
		try
		{
			List<Branches> allBranches = branchservice.getAllBranches();
			if(!allBranches.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.OK).body(allBranches);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Branches Found in the database.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
	
	@PutMapping("/updateBranch/{id}")
	public ResponseEntity<?> updateBranch(@RequestBody Branches branch,@PathVariable int id)
	{
		try
		{	
			Branches updateBranch = branchservice.updateBranch(branch, id);
			if(updateBranch!=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body("Branch Updated Successfully.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Branch found to update.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
	
	@GetMapping("/getBranchesByCompanyId/{cid}")
	public ResponseEntity<?> getBranchesByCompanyId(@PathVariable int cid)
	{
		try
		{
			List<Branches> branchByCompanyId = branchservice.getBranchByCompanyId(cid);
			if(branchByCompanyId.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Branches found for particular company.");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.OK).body(branchByCompanyId);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}
	}
}
