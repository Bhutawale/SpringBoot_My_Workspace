package com.microservice.hotelservice.HotelService.Service;

import java.util.List;
import java.util.Optional;

import com.microservice.hotelservice.HotelService.Entity.Hotel;

public interface HotlServiceI
{
	public Hotel addHotel(Hotel hotel);
	
	public Optional<Hotel> getHotelById(int hid);
	
	public List<Hotel> getAllHotel();
	
	public void deleteHotel(int hid);
	
	public Hotel updateHotel(Hotel hotel);
}
