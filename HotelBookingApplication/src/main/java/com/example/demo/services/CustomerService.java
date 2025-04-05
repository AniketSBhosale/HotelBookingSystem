package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repo;
    
    public boolean isAddNewCustomer(CustomerModel model) {
        return repo.isAddNewCustomers(model);
    }

    public List<CustomerModel> getAllCustomers() {
        return repo.getAllCustomers();
    }

    public CustomerModel searchById(Integer id) {
        return repo.searchById(id);
    }

    public boolean deleteById(Integer id) {
        return repo.deleteById(id);
    }
}
