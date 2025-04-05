package com.example.demo.model;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerModel {
private int customer_id;
private String name;
private String email;
private String password;
private String phone;
private Timestamp created_at;
}
