package com.sample.rtdnregression.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sample.rtdnregression.entities.DNEntity;
import com.sample.rtdnregression.entities.XIstRespRevCodEntity;

@Service
public class DNService {
	@Autowired
	@Qualifier("dnjdbctemplate")
	private JdbcTemplate jdbcTemplate;

	public List<DNEntity> getDNData() {
		String sql = "SELECT * FROM dn";
		List<DNEntity> dnEntities = jdbcTemplate.query(sql, new DNRowMapper());
		return dnEntities;
	}

	public List<XIstRespRevCodEntity> getXIstRespRevCod() {
		String sql = "SELECT * FROM dn";
		List<XIstRespRevCodEntity> dnEntities = jdbcTemplate.query(sql, new XIstRespRevCodRowMapper());
		return dnEntities;
	}
}
