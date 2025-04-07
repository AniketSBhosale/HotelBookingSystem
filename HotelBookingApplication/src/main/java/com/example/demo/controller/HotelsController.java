package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HotelsModel;
import com.example.demo.services.HotelsService;

@RestController
public class HotelsController {

    @Autowired
    HotelsService service;

    @PostMapping("/addHotels")
    public String addNewHotel(@RequestBody HotelsModel model) {
        Boolean isAdded = service.isAddNewHotel(model);
        if (isAdded) {
            return "Hotel Added Successfully!";
        } else {
            return "Failed to Add Hotel. Please check the owner ID.";
        }
    }
}
