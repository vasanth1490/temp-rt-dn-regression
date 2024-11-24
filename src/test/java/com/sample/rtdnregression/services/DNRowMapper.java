package com.sample.rtdnregression.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.rtdnregression.entities.DNEntity;

public class DNRowMapper implements RowMapper<DNEntity> {

	@Override
	public DNEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		DNEntity entity = new DNEntity();
		entity.setTransactionId(rs.getString("trans_id"));
		entity.setMti(rs.getString("mti"));
		entity.setFuncCode(rs.getString("func_code"));
		entity.setDraftCaptureFlg(rs.getString("draft_capture_flg"));
		entity.setStandinAct(rs.getString("standin_act"));
		entity.setDateReconAcq(rs.getString("date_recon_acq"));
		entity.setAmtReconAcq(rs.getString("amt_recon_acq"));
		entity.setoAmtReconAcq(rs.getString("o_amt_recon_acq"));
		entity.setAdlRqstAmt1(rs.getString("adl_rqst_amt1"));
		entity.setCurReconAcq(rs.getString("cur_recon_acq"));
		entity.setDateCnvAcq(rs.getString("date_cnv_acq"));
		entity.setCnvRcnAcqDePos(rs.getString("cnv_rcn_acq_de_pos"));
		entity.setCnvRcnAcqRate(rs.getString("cnv_rcn_acq_rate"));
		return entity;
	}

}
