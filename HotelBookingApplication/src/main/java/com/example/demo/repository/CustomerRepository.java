package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerModel;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

  
    public boolean isAddNewCustomers(CustomerModel model) {
        Timestamp currentTimestamp = new Timestamp(new Date().getTime());

        int rowsAffected = template.update(
            "INSERT INTO owners (name, email, password, phone, created_at) VALUES (?, ?, ?, ?, ?)", 
            new PreparedStatementSetter() {
                @Override
                public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
                ps.setString(1, model.getName());
                ps.setString(2, model.getEmail());
                ps.setString(3, model.getPassword());
                ps.setString(4, model.getPhone());
                ps.setTimestamp(5, currentTimestamp);
                }
            }
        		);
           
        return rowsAffected > 0;
    }

    public List<CustomerModel> getAllCustomers() {
        return template.query("SELECT * FROM customers", new RowMapper<CustomerModel>() {
            @Override
            public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerModel customer = new CustomerModel();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getString("phone"));
                customer.setCreated_at(rs.getTimestamp("created_at"));
                return customer;
            }
        });
    }

    public CustomerModel searchById(int id) {
        List<CustomerModel> list = template.query(
            "SELECT * FROM owners WHERE Customer_id = ?", new Object[]{id}, 
            new RowMapper<CustomerModel>() {
                @Override
                public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                	CustomerModel model = new CustomerModel();
                	model.setCustomer_id(rs.getInt("owner_id"));
                	model.setName(rs.getString("name"));
                	model.setEmail(rs.getString("email"));
                	model.setPassword(rs.getString("password"));
                	model.setPhone(rs.getString("phone"));
                	model.setCreated_at(rs.getTimestamp("created_at"));
                    return model;
                }
            });

        return list.isEmpty() ? null : list.get(0);
    }


    public boolean deleteById(Integer id) {
        int rowsAffected = template.update("DELETE FROM customers WHERE customer_id = ?", id);
        return rowsAffected > 0;
    }
}
