package com.sample.rtdnregression.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.rtdnregression.Constants;
import com.sample.rtdnregression.entities.DNEntity;

public class DNRowMapper implements RowMapper<DNEntity> {

	@Override
	public DNEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		DNEntity entity = new DNEntity();
		entity.setTransactionId(rs.getString(Constants.DN_TRAN_NUMBER));
		entity.setMti(rs.getString(Constants.DN_MTI));
		entity.setFuncCode(rs.getString(Constants.DN_FUNC_CODE));
		entity.setDraftCaptureFlg(rs.getString(Constants.DN_DRAFT_CAPTURE_FLG));
		entity.setStandinAct(rs.getString(Constants.DN_STANDIN_ACT));
		entity.setDateReconAcq(rs.getString(Constants.DN_DATE_RECON_ACQ));
		entity.setAmtReconAcq(rs.getString(Constants.DN_AMT_RECON_ACQ));
		entity.setoAmtReconAcq(rs.getString(Constants.DN_O_AMT_RECON_ACQ));
		entity.setAdlRqstAmt1(rs.getString(Constants.DN_ADL_RQST_AMT1));
		entity.setCurReconAcq(rs.getString(Constants.DN_CUR_RECON_ACQ));
		entity.setDateCnvAcq(rs.getString(Constants.DN_DATE_CNV_ACQ));
		entity.setCnvRcnAcqDePos(rs.getString(Constants.DN_CNV_RCN_ACQ_DE_POS));
		entity.setCnvRcnAcqRate(rs.getString(Constants.DN_CNV_RCN_ACQ_RATE));
		entity.setSysAuditTrace(rs.getString(Constants.DN_SYS_AUDIT_TRACE));
		entity.setAmtReconIss(rs.getString(Constants.DN_AMT_RECON_ISS));
		entity.setAmtReconNet(rs.getString(Constants.DN_AMT_RECON_NET));
		entity.setAmtCardBill(rs.getString(Constants.DN_AMT_CARD_BILL));
		entity.setoAmtCardBill(rs.getString(Constants.DN_O_AMT_CARD_BILL));
		entity.setoAmtReconIss(rs.getString(Constants.DN_O_AMT_RECON_ISS));
		entity.setoAmtReconNet(rs.getString(Constants.DN_O_AMT_RECON_NET));
		return entity;
	}

}
