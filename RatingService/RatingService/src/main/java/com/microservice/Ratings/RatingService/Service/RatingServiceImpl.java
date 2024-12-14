package com.microservice.Ratings.RatingService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.Ratings.RatingService.Dao.RatingDao;
import com.microservice.Ratings.RatingService.Entity.Rating;

@Service
public class RatingServiceImpl implements RatingServiceI {

	@Autowired
	private RatingDao ratingdao;
	
	public Rating addRating(Rating rating) 
	{
		return ratingdao.save(rating);
	}

	public Optional<Rating> getRatingById(int rid) 
	{
		return ratingdao.findById(rid);
	}

	public List<Rating> getAllRating()
	{
		return ratingdao.findAll();
	}

	public void deleteRating(int rid) 
	{
		ratingdao.deleteById(rid);
	}

	public Rating updateRating(Rating rating)
	{
		return ratingdao.save(rating);
	}

	public List<Rating> getRatingByUserId(int uid) 
	{
		
		return ratingdao.findByUid(uid);
	}

	
	public List<Rating> getRatingByHotelId(int hid)
	{
		return ratingdao.findByHid(hid);
	}

}
