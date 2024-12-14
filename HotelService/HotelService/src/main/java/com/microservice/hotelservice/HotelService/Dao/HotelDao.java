package com.microservice.hotelservice.HotelService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.hotelservice.HotelService.Entity.Hotel;
@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

}
