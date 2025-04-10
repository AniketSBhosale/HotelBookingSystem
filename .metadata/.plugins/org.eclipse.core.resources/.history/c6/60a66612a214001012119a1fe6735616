package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HotelsModel;
import com.example.demo.repository.HotelsRepository;

@Service
public class HotelsService {
	@Autowired
	HotelsRepository repo;
	public Boolean isAddNewHotel(HotelsModel model) {
		return repo.isAddNewHotel(model); 
	}
	
}
