package com.sample.rtdnregression.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.rtdnregression.entities.RTEntity;

public class RTRowMapper implements RowMapper<RTEntity> {

	@Override
	public RTEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		RTEntity entity = new RTEntity();
		entity.setTransactionId(rs.getString("trans_id"));
		entity.setMsgType(rs.getString("msg_type"));
		entity.setDraftCapture(rs.getString("draft_capture"));
		entity.setStandIn(rs.getString("stand_in"));
		entity.setSrcnodeDateSettle(rs.getString("srcnode_date_settle"));
		entity.setSrcnodeAmountRequested(rs.getString("srcnode_amount_requested"));
		entity.setSrcnodeCashRequested(rs.getString("srcnode_cash_requested"));
		entity.setSrcnodeCurrencyCode(rs.getString("srcnode_currency_code"));
		entity.setSrcnodeDateConversion(rs.getString("srcnode_date_conversion"));
		entity.setSrcnodeConversionRate(rs.getString("srcnode_conversion_rate"));
		return entity;
	}

}
