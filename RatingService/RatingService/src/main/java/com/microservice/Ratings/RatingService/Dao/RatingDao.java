package com.microservice.Ratings.RatingService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.Ratings.RatingService.Entity.Rating;

@Repository
public interface RatingDao extends JpaRepository<Rating, Integer>
{
	 List<Rating> findByUid(int uid);
	
	 List<Rating> findByHid(int hid);
}
