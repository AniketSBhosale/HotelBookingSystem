package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UsersModel;

@Repository
public class UsersRepository {

    @Autowired
    private JdbcTemplate template;

    public boolean isAddNewUser(UsersModel model) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        String sql = "INSERT INTO users (name, email, password, phone, role_id, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        int rowsAffected = template.update(sql,
            model.getName(),
            model.getEmail(),
            model.getPassword(),
            model.getPhone(),
            model.getRole_id(),
            currentTimestamp
        );

        return rowsAffected > 0;
    }
}
