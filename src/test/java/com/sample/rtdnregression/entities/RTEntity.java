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
	private String snknodeCashRequested;
	private String snknodeCurrencyCode;
	private String snknodeConversionRate;
	private String snknodeDateConversion;
	private String tranType;
	private String toAccount;
	private String amountTranRequested;
	private String timeLocal;
	private String dateLocal;

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

	public String getSnknodeCashRequested() {
		return snknodeCashRequested;
	}

	public void setSnknodeCashRequested(String snknodeCashRequested) {
		this.snknodeCashRequested = snknodeCashRequested;
	}

	public String getSnknodeCurrencyCode() {
		return snknodeCurrencyCode;
	}

	public void setSnknodeCurrencyCode(String snknodeCurrencyCode) {
		this.snknodeCurrencyCode = snknodeCurrencyCode;
	}

	public String getSnknodeConversionRate() {
		return snknodeConversionRate;
	}

	public void setSnknodeConversionRate(String snknodeConversionRate) {
		this.snknodeConversionRate = snknodeConversionRate;
	}

	public String getSnknodeDateConversion() {
		return snknodeDateConversion;
	}

	public void setSnknodeDateConversion(String snknodeDateConversion) {
		this.snknodeDateConversion = snknodeDateConversion;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getAmountTranRequested() {
		return amountTranRequested;
	}

	public void setAmountTranRequested(String amountTranRequested) {
		this.amountTranRequested = amountTranRequested;
	}

	public String getTimeLocal() {
		return timeLocal;
	}

	public void setTimeLocal(String timeLocal) {
		this.timeLocal = timeLocal;
	}

	public String getDateLocal() {
		return dateLocal;
	}

	public void setDateLocal(String dateLocal) {
		this.dateLocal = dateLocal;
	}

}
