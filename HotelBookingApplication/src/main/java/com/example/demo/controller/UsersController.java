package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UsersModel;
import com.example.demo.services.UsersService;

@RestController
public class UsersController {
	@Autowired
	UsersService service;
	 @PostMapping("/addUsers")
	    public String addNewUsers(@RequestBody UsersModel model) {
	        boolean success = service.isAddNewUser(model);
	        return success ? "User Added Successfully" : "User not added";
	    }
}
