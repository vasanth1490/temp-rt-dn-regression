package com.sample.rtdnregression.entities;

public class DNEntity {
	private String tranNumber;
	private String mti;
	private String funcCode;
	private String draftCaptureFlg;
	private String standinAct;
	private String dateReconAcq;
	private String amtReconAcq;
	private String oAmtReconAcq;
	private String adlRqstAmt1;
	private String adlRqstAmtTyp1;
	private String curReconAcq;
	private String dateCnvAcq;
	private String cnvRcnAcqDePos;
	private String cnvRcnAcqRate;
	private String sysTraceAuditNo;
	private String amtReconIss;
	private String amtReconNet;
	private String amtCardBill;
	private String oAmtCardBill;
	private String oAmtReconIss;
	private String oAmtReconNet;
	private String adlRespAmt0;
	private String adlRqstAmtTyp0;
	private String curReconIss;
	private String curReconNet;
	private String curCardBill;
	private String cnvRcnIssDePos;
	private String cnvRcnIssRate;
	private String dateCnvIss;
	private String tranTypeId;
	private String amtTran;
	private String oAmtTran;
	private String tstampLocal;
	private String merchType;
	private String cardAcptBusCode;
	private String cardAcptId;
	private String rptLvlIdB;
	private String curTran;
	private String msgResonCodeIss;
	private String msgResonCodeAcq;
	private String tranDesc;

	private String odeMti;
	private String odeSysTraAudNo;
	private String odeTstampLoclTr;
	private String odeInstIsAcq;
	private String dateReconIss;
	private String dateReconNet;
	private String instIdReconIss;
	private String instIdRecnIssB;
	private String gmtTime;
	private String instIdAcq;
	private String extRspCode;
	private String actCode;
	private String cardAcptNameLoc;
	private String cardAcptRegion;
	private String cardAcptCountry;
	private String instIdIss;
	private String cvvCvcResult;
	private String cavvResult;

	public DNEntity() {
		super();
	}

	public DNEntity(String tranNumber, String mti, String funcCode) {
		super();
		this.tranNumber = tranNumber;
		this.mti = mti;
		this.funcCode = funcCode;
	}

	public String getMti() {
		return mti;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public String getDraftCaptureFlg() {
		return draftCaptureFlg;
	}

	public void setDraftCaptureFlg(String draftCaptureFlg) {
		this.draftCaptureFlg = draftCaptureFlg;
	}

	public String getStandinAct() {
		return standinAct;
	}

	public void setStandinAct(String standinAct) {
		this.standinAct = standinAct;
	}

	public String getDateReconAcq() {
		return dateReconAcq;
	}

	public void setDateReconAcq(String dateReconAcq) {
		this.dateReconAcq = dateReconAcq;
	}

	public String getAmtReconAcq() {
		return amtReconAcq;
	}

	public void setAmtReconAcq(String amtReconAcq) {
		this.amtReconAcq = amtReconAcq;
	}

	public String getoAmtReconAcq() {
		return oAmtReconAcq;
	}

	public void setoAmtReconAcq(String oAmtReconAcq) {
		this.oAmtReconAcq = oAmtReconAcq;
	}

	public String getAdlRqstAmt1() {
		return adlRqstAmt1;
	}

	public void setAdlRqstAmt1(String adlRqstAmt1) {
		this.adlRqstAmt1 = adlRqstAmt1;
	}

	public String getCurReconAcq() {
		return curReconAcq;
	}

	public void setCurReconAcq(String curReconAcq) {
		this.curReconAcq = curReconAcq;
	}

	public String getDateCnvAcq() {
		return dateCnvAcq;
	}

	public void setDateCnvAcq(String dateCnvAcq) {
		this.dateCnvAcq = dateCnvAcq;
	}

	public String getCnvRcnAcqDePos() {
		return cnvRcnAcqDePos;
	}

	public void setCnvRcnAcqDePos(String cnvRcnAcqDePos) {
		this.cnvRcnAcqDePos = cnvRcnAcqDePos;
	}

	public String getCnvRcnAcqRate() {
		return cnvRcnAcqRate;
	}

	public void setCnvRcnAcqRate(String cnvRcnAcqRate) {
		this.cnvRcnAcqRate = cnvRcnAcqRate;
	}

	public String getAmtReconIss() {
		return amtReconIss;
	}

	public void setAmtReconIss(String amtReconIss) {
		this.amtReconIss = amtReconIss;
	}

	public String getAmtReconNet() {
		return amtReconNet;
	}

	public void setAmtReconNet(String amtReconNet) {
		this.amtReconNet = amtReconNet;
	}

	public String getAmtCardBill() {
		return amtCardBill;
	}

	public void setAmtCardBill(String amtCardBill) {
		this.amtCardBill = amtCardBill;
	}

	public String getoAmtCardBill() {
		return oAmtCardBill;
	}

	public void setoAmtCardBill(String oAmtCardBill) {
		this.oAmtCardBill = oAmtCardBill;
	}

	public String getoAmtReconIss() {
		return oAmtReconIss;
	}

	public void setoAmtReconIss(String oAmtReconIss) {
		this.oAmtReconIss = oAmtReconIss;
	}

	public String getoAmtReconNet() {
		return oAmtReconNet;
	}

	public void setoAmtReconNet(String oAmtReconNet) {
		this.oAmtReconNet = oAmtReconNet;
	}

	public String getTranNumber() {
		return tranNumber;
	}

	public void setTranNumber(String tranNumber) {
		this.tranNumber = tranNumber;
	}

	public String getSysTraceAuditNo() {
		return sysTraceAuditNo;
	}

	public void setSysTraceAuditNo(String sysTraceAuditNo) {
		this.sysTraceAuditNo = sysTraceAuditNo;
	}

	public String getAdlRespAmt0() {
		return adlRespAmt0;
	}

	public void setAdlRespAmt0(String adlRespAmt0) {
		this.adlRespAmt0 = adlRespAmt0;
	}

	public String getCurReconIss() {
		return curReconIss;
	}

	public void setCurReconIss(String curReconIss) {
		this.curReconIss = curReconIss;
	}

	public String getCurReconNet() {
		return curReconNet;
	}

	public void setCurReconNet(String curReconNet) {
		this.curReconNet = curReconNet;
	}

	public String getCurCardBill() {
		return curCardBill;
	}

	public void setCurCardBill(String curCardBill) {
		this.curCardBill = curCardBill;
	}

	public String getCnvRcnIssDePos() {
		return cnvRcnIssDePos;
	}

	public void setCnvRcnIssDePos(String cnvRcnIssDePos) {
		this.cnvRcnIssDePos = cnvRcnIssDePos;
	}

	public String getCnvRcnIssRate() {
		return cnvRcnIssRate;
	}

	public void setCnvRcnIssRate(String cnvRcnIssRate) {
		this.cnvRcnIssRate = cnvRcnIssRate;
	}

	public String getDateCnvIss() {
		return dateCnvIss;
	}

	public void setDateCnvIss(String dateCnvIss) {
		this.dateCnvIss = dateCnvIss;
	}

	public String getTranTypeId() {
		return tranTypeId;
	}

	public void setTranTypeId(String tranTypeId) {
		this.tranTypeId = tranTypeId;
	}

	public String getAmtTran() {
		return amtTran;
	}

	public void setAmtTran(String amtTran) {
		this.amtTran = amtTran;
	}

	public String getoAmtTran() {
		return oAmtTran;
	}

	public void setoAmtTran(String oAmtTran) {
		this.oAmtTran = oAmtTran;
	}

	public String getTstampLocal() {
		return tstampLocal;
	}

	public void setTstampLocal(String tstampLocal) {
		this.tstampLocal = tstampLocal;
	}

	public String getAdlRqstAmtTyp1() {
		return adlRqstAmtTyp1;
	}

	public void setAdlRqstAmtTyp1(String adlRqstAmtTyp1) {
		this.adlRqstAmtTyp1 = adlRqstAmtTyp1;
	}

	public String getAdlRqstAmtTyp0() {
		return adlRqstAmtTyp0;
	}

	public void setAdlRqstAmtTyp0(String adlRqstAmtTyp0) {
		this.adlRqstAmtTyp0 = adlRqstAmtTyp0;
	}

	public String getMerchType() {
		return merchType;
	}

	public void setMerchType(String merchType) {
		this.merchType = merchType;
	}

	public String getCardAcptBusCode() {
		return cardAcptBusCode;
	}

	public void setCardAcptBusCode(String cardAcptBusCode) {
		this.cardAcptBusCode = cardAcptBusCode;
	}

	public String getCardAcptId() {
		return cardAcptId;
	}

	public void setCardAcptId(String cardAcptId) {
		this.cardAcptId = cardAcptId;
	}

	public String getRptLvlIdB() {
		return rptLvlIdB;
	}

	public void setRptLvlIdB(String rptLvlIdB) {
		this.rptLvlIdB = rptLvlIdB;
	}

	public String getMsgResonCodeIss() {
		return msgResonCodeIss;
	}

	public void setMsgResonCodeIss(String msgResonCodeIss) {
		this.msgResonCodeIss = msgResonCodeIss;
	}

	public String getMsgResonCodeAcq() {
		return msgResonCodeAcq;
	}

	public void setMsgResonCodeAcq(String msgResonCodeAcq) {
		this.msgResonCodeAcq = msgResonCodeAcq;
	}

	public String getTranDesc() {
		return tranDesc;
	}

	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}

	public String getCurTran() {
		return curTran;
	}

	public void setCurTran(String curTran) {
		this.curTran = curTran;
	}

	public String getOdeMti() {
		return odeMti;
	}

	public void setOdeMti(String odeMti) {
		this.odeMti = odeMti;
	}

	public String getOdeSysTraAudNo() {
		return odeSysTraAudNo;
	}

	public void setOdeSysTraAudNo(String odeSysTraAudNo) {
		this.odeSysTraAudNo = odeSysTraAudNo;
	}

	public String getOdeTstampLoclTr() {
		return odeTstampLoclTr;
	}

	public void setOdeTstampLoclTr(String odeTstampLoclTr) {
		this.odeTstampLoclTr = odeTstampLoclTr;
	}

	public String getOdeInstIsAcq() {
		return odeInstIsAcq;
	}

	public void setOdeInstIsAcq(String odeInstIsAcq) {
		this.odeInstIsAcq = odeInstIsAcq;
	}

	public String getDateReconIss() {
		return dateReconIss;
	}

	public void setDateReconIss(String dateReconIss) {
		this.dateReconIss = dateReconIss;
	}

	public String getDateReconNet() {
		return dateReconNet;
	}

	public void setDateReconNet(String dateReconNet) {
		this.dateReconNet = dateReconNet;
	}

	public String getInstIdReconIss() {
		return instIdReconIss;
	}

	public void setInstIdReconIss(String instIdReconIss) {
		this.instIdReconIss = instIdReconIss;
	}

	public String getInstIdRecnIssB() {
		return instIdRecnIssB;
	}

	public void setInstIdRecnIssB(String instIdRecnIssB) {
		this.instIdRecnIssB = instIdRecnIssB;
	}

	public String getGmtTime() {
		return gmtTime;
	}

	public void setGmtTime(String gmtTime) {
		this.gmtTime = gmtTime;
	}

	public String getInstIdAcq() {
		return instIdAcq;
	}

	public void setInstIdAcq(String instIdAcq) {
		this.instIdAcq = instIdAcq;
	}

	public String getExtRspCode() {
		return extRspCode;
	}

	public void setExtRspCode(String extRspCode) {
		this.extRspCode = extRspCode;
	}

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getCardAcptNameLoc() {
		return cardAcptNameLoc;
	}

	public void setCardAcptNameLoc(String cardAcptNameLoc) {
		this.cardAcptNameLoc = cardAcptNameLoc;
	}

	public String getCardAcptRegion() {
		return cardAcptRegion;
	}

	public void setCardAcptRegion(String cardAcptRegion) {
		this.cardAcptRegion = cardAcptRegion;
	}

	public String getCardAcptCountry() {
		return cardAcptCountry;
	}

	public void setCardAcptCountry(String cardAcptCountry) {
		this.cardAcptCountry = cardAcptCountry;
	}

	public String getInstIdIss() {
		return instIdIss;
	}

	public void setInstIdIss(String instIdIss) {
		this.instIdIss = instIdIss;
	}

	public String getCvvCvcResult() {
		return cvvCvcResult;
	}

	public void setCvvCvcResult(String cvvCvcResult) {
		this.cvvCvcResult = cvvCvcResult;
	}

	public String getCavvResult() {
		return cavvResult;
	}

	public void setCavvResult(String cavvResult) {
		this.cavvResult = cavvResult;
	}

}
