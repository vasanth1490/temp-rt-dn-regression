package com.sample.rtdnregression.entities;

public class RTEntity {
	private String rtName;
	private String tranNr;
	private String msgType;
	private String draftCapture;
	private String standIn;
	private String srcnodeDateSettle;
	private String srcnodeAmountRequested;
	private String srcnodeCashRequested;
	private String srcnodeCurrencyCode;
	private String srcnodeDateConversion;
	private String srcnodeConversionRate;
	private String snknodeReqSysTrace;
	private String snknodeRevSysTrace;
	private String snknodeAdvSysTrace;
	private String snknodeAmountRequested;

	public RTEntity() {
		super();
	}

	public RTEntity(String transactionId, String msgType) {
		super();
		this.setTranNr(transactionId);
		this.msgType = msgType;
	}



	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getDraftCapture() {
		return draftCapture;
	}

	public void setDraftCapture(String draftCapture) {
		this.draftCapture = draftCapture;
	}

	public String getStandIn() {
		return standIn;
	}

	public void setStandIn(String standIn) {
		this.standIn = standIn;
	}

	public String getSrcnodeDateSettle() {
		return srcnodeDateSettle;
	}

	public void setSrcnodeDateSettle(String srcnodeDateSettle) {
		this.srcnodeDateSettle = srcnodeDateSettle;
	}

	public String getSrcnodeAmountRequested() {
		return srcnodeAmountRequested;
	}

	public void setSrcnodeAmountRequested(String srcnodeAmountRequested) {
		this.srcnodeAmountRequested = srcnodeAmountRequested;
	}

	public String getSrcnodeCashRequested() {
		return srcnodeCashRequested;
	}

	public void setSrcnodeCashRequested(String srcnodeCashRequested) {
		this.srcnodeCashRequested = srcnodeCashRequested;
	}

	public String getSrcnodeCurrencyCode() {
		return srcnodeCurrencyCode;
	}

	public void setSrcnodeCurrencyCode(String srcnodeCurrencyCode) {
		this.srcnodeCurrencyCode = srcnodeCurrencyCode;
	}

	public String getSrcnodeDateConversion() {
		return srcnodeDateConversion;
	}

	public void setSrcnodeDateConversion(String srcnodeDateConversion) {
		this.srcnodeDateConversion = srcnodeDateConversion;
	}

	public String getSrcnodeConversionRate() {
		return srcnodeConversionRate;
	}

	public void setSrcnodeConversionRate(String srcnodeConversionRate) {
		this.srcnodeConversionRate = srcnodeConversionRate;
	}

	public String getRtName() {
		return rtName;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public String getTranNr() {
		return tranNr;
	}

	public void setTranNr(String tranNr) {
		this.tranNr = tranNr;
	}

	public String getSnknodeReqSysTrace() {
		return snknodeReqSysTrace;
	}

	public void setSnknodeReqSysTrace(String snknodeReqSysTrace) {
		this.snknodeReqSysTrace = snknodeReqSysTrace;
	}

	public String getSnknodeRevSysTrace() {
		return snknodeRevSysTrace;
	}

	public void setSnknodeRevSysTrace(String snknodeRevSysTrace) {
		this.snknodeRevSysTrace = snknodeRevSysTrace;
	}

	public String getSnknodeAdvSysTrace() {
		return snknodeAdvSysTrace;
	}

	public void setSnknodeAdvSysTrace(String snknodeAdvSysTrace) {
		this.snknodeAdvSysTrace = snknodeAdvSysTrace;
	}

	public String getSnknodeAmountRequested() {
		return snknodeAmountRequested;
	}

	public void setSnknodeAmountRequested(String snknodeAmountRequested) {
		this.snknodeAmountRequested = snknodeAmountRequested;
	}

	
}
