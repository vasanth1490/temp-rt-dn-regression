package com.sample.rtdnregression.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sample.rtdnregression.entities.RTEntity;

@Service
public class RTService {
	
	@Autowired
	@Qualifier("rtjdbctemplate")
	private JdbcTemplate jdbcTemplate;
	
	public List<RTEntity> getRTData() {
		String sql = "SELECT * FROM rt";
		List<RTEntity> rtEntities = jdbcTemplate.query(sql, new RTRowMapper("RT01"));
		return rtEntities;
	}
}
