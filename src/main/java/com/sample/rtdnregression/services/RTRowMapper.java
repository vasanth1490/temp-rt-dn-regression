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
		entity.setSnknodeAmountRequested(rs.getString(Constants.RT_SNKNODE_AMOUNT_REQUESTED));
		entity.setSnknodeCashRequested(rs.getString(Constants.RT_SNKNODE_CASH_REQUESTED));
		entity.setSnknodeCurrencyCode(rs.getString(Constants.RT_SNKNODE_CURRENCY_CODE));
		entity.setSnknodeConversionRate(rs.getString(Constants.RT_SNKNODE_CONVERSION_RATE));
		entity.setSnknodeDateConversion(rs.getString(Constants.RT_SNKNODE_DATE_CONVERSION));
		entity.setTranType(rs.getString(Constants.RT_TRAN_TYPE));
		entity.setFromAccount(rs.getString(Constants.RT_FROM_ACCOUNT));
		entity.setToAccount(rs.getString(Constants.RT_TO_ACCOUNT));
		entity.setAmountTranRequested(rs.getString(Constants.RT_AMOUNT_TRAN_REQUESTED));
		entity.setTimeLocal(rs.getString(Constants.RT_TIME_LOCAL));
		entity.setDateLocal(rs.getString(Constants.RT_DATE_LOCAL));
		entity.setMerchantType(rs.getString(Constants.RT_MERCHANT_TYPE));
		entity.setCardAcceptorIdCode(rs.getString(Constants.RT_CARD_ACCEPTOR_ID_CODE));
		entity.setCurrencyCodeTran(rs.getString(Constants.RT_CURRENCY_CODE_TRAN));
		entity.setMsgReasonCodeReqOut(rs.getString(Constants.RT_MSG_REASON_CODE_REQ_OUT));
		entity.setMsgReasonCodeRev(rs.getString(Constants.RT_MSG_REASON_CODE_REV));
		entity.setMsgReasonCodeAdv(rs.getString(Constants.RT_MSG_REASON_CODE_ADV));
		entity.setAbortReason(rs.getString(Constants.RT_ABORT_REASON));
		entity.setAbortRspCode(rs.getString(Constants.RT_ABORT_RSP_CODE));
		entity.setSrcnodeOriginalData(rs.getString(Constants.RT_SRCNODE_ORIGINAL_DATA));
		entity.setSnknodeDateSettle(rs.getString(Constants.RT_SNKNODE_DATE_SETTLE));
		entity.setTotalsGroup(rs.getString(Constants.RT_TOTALS_GROUP));
		entity.setGmtDateTime(rs.getString(Constants.RT_GMT_DATE_TIME));
		entity.setAcquiringInst(rs.getString(Constants.RT_ACQUIRING_INST));
		entity.setRspCodeReqRsp(rs.getString(Constants.RT_RSP_CODE_REQ_RSP));
		entity.setCardAcceptorNameLoc(rs.getString(Constants.RT_CARD_ACCEPTOR_NAME_LOC));
		entity.setInReq(rs.getString(Constants.RT_IN_REQ));
		entity.setInAdv(rs.getString(Constants.RT_IN_ADV));
		entity.setInRev(rs.getString(Constants.RT_IN_REV));
		entity.setSnknodeAcquiringInst(rs.getString(Constants.RT_SNKNODE_ACQUIRING_INST));
		entity.setCardVerificationResult(rs.getString(Constants.RT_CARD_VERIFICATION_RESULT));
		entity.setSecure3dResult(rs.getString(Constants.RT_SECURE_3D_RESULT));

		entity.setCardAcceptorTermId(rs.getString(Constants.RT_CARD_ACCEPTOR_TERM_ID));
		entity.setPosDataCode(rs.getString(Constants.RT_POS_DATA_CODE));
		entity.setUcafData(rs.getString(Constants.RT_UCAF_DATA));

		entity.setAmountCashRequested(rs.getString(Constants.RT_AMOUNT_CASH_REQUESTED));
		entity.setAddrVerificationResult(rs.getString(Constants.RT_ADDR_VERIFICATION_RESULT));
		
		entity.setRetRefNo(rs.getString(Constants.RT_RET_REF_NO));
		
		entity.setStructuredDataReq(rs.getString(Constants.RT_STRUCTURED_DATA_REQ));
		entity.setAuthIdResp(rs.getString(Constants.RT_AUTH_ID_RESP));
		

		return entity;
	}

}
