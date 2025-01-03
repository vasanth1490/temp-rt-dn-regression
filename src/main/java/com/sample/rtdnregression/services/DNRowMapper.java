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
		entity.setTranNumber(rs.getString(Constants.DN_TRAN_NUMBER));
		entity.setMti(rs.getString(Constants.DN_MTI));
		entity.setFuncCode(rs.getString(Constants.DN_FUNC_CODE));
		entity.setDraftCaptureFlg(rs.getString(Constants.DN_DRAFT_CAPTURE_FLG));
		entity.setStandinAct(rs.getString(Constants.DN_STANDIN_ACT));
		entity.setDateReconAcq(rs.getString(Constants.DN_DATE_RECON_ACQ));
		entity.setAmtReconAcq(rs.getString(Constants.DN_AMT_RECON_ACQ));
		entity.setoAmtReconAcq(rs.getString(Constants.DN_O_AMT_RECON_ACQ));
		entity.setAdlRqstAmt1(rs.getString(Constants.DN_ADL_RQST_AMT1));
		entity.setAdlRqstAmtTyp1(rs.getString(Constants.DN_ADL_RQST_AMT_TYP1));
		entity.setCurReconAcq(rs.getString(Constants.DN_CUR_RECON_ACQ));
		entity.setDateCnvAcq(rs.getString(Constants.DN_DATE_CNV_ACQ));
		entity.setCnvRcnAcqDePos(rs.getString(Constants.DN_CNV_RCN_ACQ_DE_POS));
		entity.setCnvRcnAcqRate(rs.getString(Constants.DN_CNV_RCN_ACQ_RATE));
		entity.setSysTraceAuditNo(rs.getString(Constants.DN_SYS_TRACE_AUDIT_NO));
		entity.setAmtReconIss(rs.getString(Constants.DN_AMT_RECON_ISS));
		entity.setAmtReconNet(rs.getString(Constants.DN_AMT_RECON_NET));
		entity.setAmtCardBill(rs.getString(Constants.DN_AMT_CARD_BILL));
		entity.setoAmtCardBill(rs.getString(Constants.DN_O_AMT_CARD_BILL));
		entity.setoAmtReconIss(rs.getString(Constants.DN_O_AMT_RECON_ISS));
		entity.setoAmtReconNet(rs.getString(Constants.DN_O_AMT_RECON_NET));
		entity.setAdlRespAmt0(rs.getString(Constants.DN_ADL_RESP_AMT0));
		entity.setAdlRqstAmtTyp0(rs.getString(Constants.DN_ADL_RQST_AMT_TYP0));
		entity.setCurReconIss(rs.getString(Constants.DN_CUR_RECON_ISS));
		entity.setCurReconNet(rs.getString(Constants.DN_CUR_RECON_NET));
		entity.setCurCardBill(rs.getString(Constants.DN_CUR_CARD_BILL));
		entity.setCnvRcnIssDePos(rs.getString(Constants.DN_CNV_RCN_ISS_DE_POS));
		entity.setCnvRcnIssRate(rs.getString(Constants.DN_CNV_RCN_ISS_RATE));
		entity.setDateCnvIss(rs.getString(Constants.DN_DATE_CNV_ISS));
		entity.setTranTypeId(rs.getString(Constants.DN_TRAN_TYPE_ID));
		entity.setAmtTran(rs.getString(Constants.DN_AMT_TRAN));
		entity.setoAmtTran(rs.getString(Constants.DN_O_AMT_TRAN));
		entity.setTstampLocal(rs.getString(Constants.DN_TSTAMP_LOCAL));
		entity.setMerchType(rs.getString(Constants.DN_MERCH_TYPE));
		entity.setCardAcptBusCode(rs.getString(Constants.DN_CARD_ACPT_BUS_CODE));
		entity.setCardAcptId(rs.getString(Constants.DN_CARD_ACPT_ID));
		entity.setRptLvlIdB(rs.getString(Constants.DN_RPT_LVL_ID_B));
		entity.setCurTran(rs.getString(Constants.DN_CUR_TRAN));
		entity.setMsgResonCodeIss(rs.getString(Constants.DN_MSG_RESON_CODE_ISS));
		entity.setMsgResonCodeAcq(rs.getString(Constants.DN_MSG_RESON_CODE_ACQ));
		entity.setTranDesc(rs.getString(Constants.DN_TRAN_DESC));
		entity.setOdeMti(rs.getString(Constants.DN_ODE_MTI));
		entity.setOdeSysTraAudNo(rs.getString(Constants.DN_ODE_SYS_TRA_AUD_NO));
		entity.setOdeTstampLoclTr(rs.getString(Constants.DN_ODE_TSTAMP_LOCL_TR));
		entity.setOdeInstIdAcq(rs.getString(Constants.DN_ODE_INST_ID_ACQ));
		entity.setDateReconIss(rs.getString(Constants.DN_DATE_RECON_ISS));
		entity.setDateReconNet(rs.getString(Constants.DN_DATE_RECON_NET));
		entity.setInstIdReconIss(rs.getString(Constants.DN_INST_ID_RECON_ISS));
		entity.setInstIdRecnIssB(rs.getString(Constants.DN_INST_ID_RECN_ISS_B));
		entity.setGmtTime(rs.getString(Constants.DN_GMT_TIME));
		entity.setInstIdAcq(rs.getString(Constants.DN_INST_ID_ACQ));
		entity.setExtRspCode(rs.getString(Constants.DN_EXT_RSP_CODE));
		entity.setActCode(rs.getString(Constants.DN_ACT_CODE));
		entity.setCardAcptNameLoc(rs.getString(Constants.DN_CARD_ACPT_NAME_LOC));
		entity.setCardAcptRegion(rs.getString(Constants.DN_CARD_ACPT_REGION));
		entity.setCardAcptCountry(rs.getString(Constants.DN_CARD_ACPT_COUNTRY));
		entity.setInstIdIss(rs.getString(Constants.DN_INST_ID_ISS));
		entity.setCvvCvcResult(rs.getString(Constants.DN_CVV_CVC_RESULT));
		entity.setCavvResult(rs.getString(Constants.DN_CAVV_RESULT));
		
		entity.setCardAcptTermId(rs.getString(Constants.DN_CARD_ACPT_TERM_ID));
		entity.setNetTermId(rs.getString(Constants.DN_NET_TERM_ID));
		entity.setPosCrdDatInCap(rs.getString(Constants.DN_POS_CRD_DAT_IN_CAP));
		entity.setPosCrdhldrAuthC(rs.getString(Constants.DN_POS_CRDHLDR_AUTH_C));
		entity.setPosCardCaptCap(rs.getString(Constants.DN_POS_CARD_CAPT_CAP));
		entity.setPosOperEnv(rs.getString(Constants.DN_POS_OPER_ENV));
		entity.setPosCrdhldrPresnt(rs.getString(Constants.DN_POS_CRDHLDR_PRESNT));
		entity.setPosCardPres(rs.getString(Constants.DN_POS_CARD_PRES));
		entity.setPosCrdDatInMod(rs.getString(Constants.DN_POS_CRD_DAT_IN_MOD));
		entity.setPosCrdhldrAMeth(rs.getString(Constants.DN_POS_CRDHLDR_A_METH));
		entity.setPosCrdhldrAuth(rs.getString(Constants.DN_POS_CRDHLDR_AUTH));
		entity.setPosCrdDatOtCap(rs.getString(Constants.DN_POS_CRD_DAT_OT_CAP));
		entity.setPosTermOutCap(rs.getString(Constants.DN_POS_TERM_OUT_CAP));
		entity.setPosPinCaptCap(rs.getString(Constants.DN_POS_PIN_CAPT_CAP));
		entity.setPosTermOptr(rs.getString(Constants.DN_POS_TERM_OPTR));
		entity.setTermClass(rs.getString(Constants.DN_TERM_CLASS));
		entity.setFinLTstampTrans(rs.getString(Constants.DN_FIN_L_TSTAMP_TRANS));
		entity.setFinRecordTstampTrans(rs.getString(Constants.DN_FIN_RECORD_TSTAMP_TRANS));
		entity.setMciUcafData(rs.getString(Constants.DN_MCI_UCAF_DATA));
		
		entity.setAdlRqstAmt0(rs.getString(Constants.DN_ADL_RQST_AMT0));
		entity.setAdlDataPrivIss(rs.getString(Constants.DN_ADL_DATA_PRIV_ISS));
		entity.setProcIdIss(rs.getString(Constants.DN_PROC_ID_ISS));
		
		entity.setRetrievalRefNo(rs.getString(Constants.DN_RETRIEVAL_REF_NO));
		entity.setPanIndicator(rs.getString(Constants.DN_PAN_INDICATOR));
		entity.setTokenRequestorId(rs.getString(Constants.DN_TOKEN_REQUESTOR_ID));
		entity.setPan(rs.getString(Constants.DN_PAN));
		entity.setBinLength(rs.getString(Constants.DN_BIN_LENGTH));
		entity.setRefDataIssFmt(rs.getString(Constants.DN_REF_DATA_ISS_FMT));
		
		entity.setDataRsp(rs.getString(Constants.DN_DATA_RSP));
		entity.setRefDataIss(rs.getString(Constants.DN_REF_DATA_ISS));
		entity.setPosEntryMode(rs.getString(Constants.DN_POS_ENTRY_MODE));

		return entity;
	}

}
