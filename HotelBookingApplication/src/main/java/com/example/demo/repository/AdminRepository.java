package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminModel;


@Repository
public class AdminRepository {
	List<AdminModel> list;
	@Autowired
	private JdbcTemplate template;
	public List<AdminModel> getAllAdmin() {
		list = template.query("select * from admin",new RowMapper<AdminModel>() {

			@Override
			public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminModel adm = new AdminModel();
				adm.setAdmin_id(rs.getInt(1));
				adm.setName(rs.getString(2));
				adm.setEmail(rs.getString(3));
				adm.setPassword(rs.getString(4));
				return  adm;
			}
    		
    	});
    	return list;
	}

}
