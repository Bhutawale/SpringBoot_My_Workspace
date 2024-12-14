package com.microservice.Ratings.RatingService.Service;

import java.util.List;
import java.util.Optional;

import com.microservice.Ratings.RatingService.Entity.Rating;

public interface RatingServiceI 
{
	public Rating addRating(Rating rating);
	
	public Optional<Rating> getRatingById(int rid);
	
	public List<Rating> getAllRating();
	
	public void deleteRating(int rid);
	
	public Rating updateRating(Rating rating);
	
	public List<Rating> getRatingByUserId(int uid);
	
	public List<Rating> getRatingByHotelId(int hid);
}
