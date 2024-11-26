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
	private String curReconAcq;
	private String dateCnvAcq;
	private String cnvRcnAcqDePos;
	private String cnvRcnAcqRate;
	private String sysAuditTrace;
	private String amtReconIss;
	private String amtReconNet;
	private String amtCardBill;
	private String oAmtCardBill;
	private String oAmtReconIss;
	private String oAmtReconNet;

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

	public String getSysAuditTrace() {
		return sysAuditTrace;
	}

	public void setSysAuditTrace(String sysAuditTrace) {
		this.sysAuditTrace = sysAuditTrace;
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

}
