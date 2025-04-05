package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminModel;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository repo;
	
public List<AdminModel> getAllAdmin(){
	return repo.getAllAdmin();
}
}
