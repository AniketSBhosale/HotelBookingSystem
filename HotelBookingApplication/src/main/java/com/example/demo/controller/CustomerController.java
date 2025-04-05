package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ValueNotFoundException;
import com.example.demo.model.CustomerModel;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public String createCustomer(@RequestBody CustomerModel model) {
        boolean success = service.isAddNewCustomer(model);
        return success ? "Owner Added" : "Owner not added";
    }

    @GetMapping("/all")
    public List<CustomerModel> getAllCustomers() {
        List<CustomerModel> list = service.getAllCustomers();
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ValueNotFoundException("No owners found in the database.");
        }
    }

    @GetMapping("/{id}")
    public CustomerModel searchById(@PathVariable("id") Integer id) {
        CustomerModel model = service.searchById(id);
        if (model != null) {
            return model;
        } else {
            throw new ValueNotFoundException("Owner not found with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean success = service.deleteById(id);
        if (success) {
            return "Owner Deleted";
        } else {
            throw new ValueNotFoundException("Owner not found with ID: " + id);
        }
    }
}
