package com.sample.rtdnregression.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.rtdnregression.Constants;
import com.sample.rtdnregression.entities.XIstRespRevCodEntity;

public class XIstRespRevCodRowMapper implements RowMapper<XIstRespRevCodEntity> {

	@Override
	public XIstRespRevCodEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		XIstRespRevCodEntity entity = new XIstRespRevCodEntity();
		entity.setIstRespRevCode(rs.getString(Constants.DN_IST_RESP_REV_CODE));
		entity.setTranDisposition(rs.getString(Constants.DN_TRAN_DISPOSITION));
		entity.setActionCode(rs.getString(Constants.DN_ACTION_CODE));

		return entity;
	}

}
