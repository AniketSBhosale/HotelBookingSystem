package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HotelsModel;
import com.example.demo.services.HotelsService;

@RestController
public class HotelsController {
	@Autowired
	HotelsService service;
	
	@PostMapping("/addHotels")
	public String addNewHotel (HotelsModel model) {
		Boolean b = service.isAddNewHotel(model);
		if(b) {
		return "Hotel Added";
	}
		else {
			return"not added";
		}
	}
	
}
