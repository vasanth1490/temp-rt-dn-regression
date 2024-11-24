package com.sample.rtdnregression.entities;

public class DNEntity {
	private String transactionId;
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

	public DNEntity() {
		super();
	}

	public DNEntity(String transactionId, String mti, String funcCode) {
		super();
		this.transactionId = transactionId;
		this.mti = mti;
		this.funcCode = funcCode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	
}
