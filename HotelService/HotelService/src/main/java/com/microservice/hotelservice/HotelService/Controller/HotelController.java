package com.microservice.hotelservice.HotelService.Controller;

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

import com.microservice.hotelservice.HotelService.Entity.Hotel;
import com.microservice.hotelservice.HotelService.Service.HotlServiceI;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
	@Autowired
	private HotlServiceI hotelservice;
	
	@PostMapping("/addHotel")
	public Hotel addHotel(@RequestBody Hotel hotel)
	{
		return hotelservice.addHotel(hotel);
	}
	
	@GetMapping("/getHotelById/{hid}")
	public Optional<Hotel> getHotelById(@PathVariable int hid)
	{
		return hotelservice.getHotelById(hid);
	}
	
	@GetMapping("/getAllHotel")
	public List<Hotel> getAllHotel()
	{
		return hotelservice.getAllHotel();
	}
	
	@DeleteMapping("/deleteHotelById/{hid}")
	public void deleteHotel(@PathVariable int hid)
	{
		hotelservice.deleteHotel(hid);
	}
	
	@PutMapping("/updateHotel")
	public Hotel updateHotel(@RequestBody Hotel hotel)
	{
		return hotelservice.updateHotel(hotel);
	}
}
