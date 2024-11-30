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
	
	

}
