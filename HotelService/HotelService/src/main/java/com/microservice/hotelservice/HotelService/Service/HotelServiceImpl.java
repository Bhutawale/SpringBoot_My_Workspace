package com.microservice.hotelservice.HotelService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotelservice.HotelService.Dao.HotelDao;
import com.microservice.hotelservice.HotelService.Entity.Hotel;

@Service
public class HotelServiceImpl implements HotlServiceI {

	@Autowired
	private HotelDao hoteldao;
	
	public Hotel addHotel(Hotel hotel)
	{
		
		return hoteldao.save(hotel) ;
	}

	
	public Optional<Hotel> getHotelById(int hid) {
		
		return hoteldao.findById(hid);
	}

	public List<Hotel> getAllHotel() 
	{
		return hoteldao.findAll();
	}


	public void deleteHotel(int hid) 
	{
		hoteldao.deleteById(hid);
		
	}

	public Hotel updateHotel(Hotel hotel)
	{
		
		return hoteldao.save(hotel);
	}

}
