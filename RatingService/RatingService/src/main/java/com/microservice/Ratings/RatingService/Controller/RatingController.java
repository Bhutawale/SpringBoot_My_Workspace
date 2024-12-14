package com.microservice.Ratings.RatingService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Ratings.RatingService.Entity.Rating;
import com.microservice.Ratings.RatingService.Service.RatingServiceI;

@RestController
@RequestMapping("/rating")
public class RatingController 
{
	@Autowired
	private RatingServiceI ratingservice;
	
	@PostMapping("/addRating")
	public Rating addRating(@RequestBody Rating rating)
	{
		return ratingservice.addRating(rating);
	}
	
	@GetMapping("/getRatingById/{rid}")
	public Optional<Rating> getRatingById(@PathVariable int rid)
	{
		return ratingservice.getRatingById(rid);
	}
	
	@GetMapping("/getAllRatings")
	public List<Rating> getAllRating()
	{
		return ratingservice.getAllRating();
	}
	
	@DeleteMapping("/deleteRating/{rid}")
	public void deleteRating(@PathVariable int rid)
	{
		ratingservice.deleteRating(rid);
	}
	
	@PutMapping("/updateRating")
	public Rating updateRating(@RequestBody Rating rating)
	{
		return ratingservice.updateRating(rating);
	}
	
	@GetMapping("/getRatingByUserId/{uid}")
	public List<Rating> getRatingByUserId(@PathVariable int uid)
	{
		return ratingservice.getRatingByUserId(uid);
	}
	
	@GetMapping("/getRatingByHotelId/{hid}")
	public List<Rating> getRatingByHotelId(@PathVariable int hid)
	{
		return ratingservice.getRatingByHotelId(hid);
	}
}
