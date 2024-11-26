package com.sample.rtdnregression.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.rtdnregression.Constants;
import com.sample.rtdnregression.entities.RTEntity;

public class RTRowMapper implements RowMapper<RTEntity> {
	
	private String rtName;
	
	public RTRowMapper() {
		super();
	}
	
	public RTRowMapper(String rtName) {
		this.rtName = rtName;
	}

	@Override
	public RTEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		RTEntity entity = new RTEntity();
		entity.setRtName(rtName);
		entity.setTranNr(rs.getString(Constants.RT_TRAN_NR));
		entity.setMsgType(rs.getString(Constants.RT_MSG_TYPE));
		entity.setDraftCapture(rs.getString(Constants.RT_DRAFT_CAPTURE));
		entity.setStandIn(rs.getString(Constants.RT_STAND_IN));
		entity.setSrcnodeDateSettle(rs.getString(Constants.RT_SRCNODE_DATE_SETTLE));
		entity.setSrcnodeAmountRequested(rs.getString(Constants.RT_SRCNODE_AMOUNT_REQUESTED));
		entity.setSrcnodeCashRequested(rs.getString(Constants.RT_SRCNODE_CASH_REQUESTED));
		entity.setSrcnodeCurrencyCode(rs.getString(Constants.RT_SRCNODE_CURRENCY_CODE));
		entity.setSrcnodeDateConversion(rs.getString(Constants.RT_SRCNODE_DATE_CONVERSION));
		entity.setSrcnodeConversionRate(rs.getString(Constants.RT_SRCNODE_CONVERSION_RATE));
		entity.setSnknodeReqSysTrace(rs.getString(Constants.RT_SNKNODE_REQ_SYS_TRACE));
		entity.setSnknodeRevSysTrace(rs.getString(Constants.RT_SNKNODE_REV_SYS_TRACE));
		entity.setSnknodeAdvSysTrace(rs.getString(Constants.RT_SNKNODE_ADV_SYS_TRACE));
		return entity;
	}

}
