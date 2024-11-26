package com.sample.rtdnregression.entities;

public class ValidationEntity {
	private String tranNr;
	private boolean msgType;
	private boolean draftCapture;
	private boolean standin;
	private boolean srcnodeDateSettle;
	private boolean srcnodeAmountRequested;
	private boolean srcnodeCashRequested;
	private boolean srcnodeCurrencyCode;
	private boolean srcnodeDateConversion;
	private boolean srcnodeConversionRate;
	private boolean snknodeReqSysTrace;
	private boolean snknodeRevSysTrace;
	private boolean snknodeAdvSysTrace;
	private boolean snknodeAmountRequested;


	public boolean isMsgType() {
		return msgType;
	}

	public void setMsgType(boolean msgType) {
		this.msgType = msgType;
	}

	public boolean isDraftCapture() {
		return draftCapture;
	}

	public void setDraftCapture(boolean draftCapture) {
		this.draftCapture = draftCapture;
	}

	public boolean isStandin() {
		return standin;
	}

	public void setStandin(boolean standin) {
		this.standin = standin;
	}

	public boolean isSrcnodeDateSettle() {
		return srcnodeDateSettle;
	}

	public void setSrcnodeDateSettle(boolean srcnodeDateSettle) {
		this.srcnodeDateSettle = srcnodeDateSettle;
	}

	public boolean isSrcnodeAmountRequested() {
		return srcnodeAmountRequested;
	}

	public void setSrcnodeAmountRequested(boolean srcnodeAmountRequested) {
		this.srcnodeAmountRequested = srcnodeAmountRequested;
	}

	public boolean isSrcnodeCashRequested() {
		return srcnodeCashRequested;
	}

	public void setSrcnodeCashRequested(boolean srcnodeCashRequested) {
		this.srcnodeCashRequested = srcnodeCashRequested;
	}

	public boolean isSrcnodeCurrencyCode() {
		return srcnodeCurrencyCode;
	}

	public void setSrcnodeCurrencyCode(boolean srcnodeCurrencyCode) {
		this.srcnodeCurrencyCode = srcnodeCurrencyCode;
	}

	public boolean isSrcnodeDateConversion() {
		return srcnodeDateConversion;
	}

	public void setSrcnodeDateConversion(boolean srcnodeDateConversion) {
		this.srcnodeDateConversion = srcnodeDateConversion;
	}

	public boolean isSrcnodeConversionRate() {
		return srcnodeConversionRate;
	}

	public void setSrcnodeConversionRate(boolean srcnodeConversionRate) {
		this.srcnodeConversionRate = srcnodeConversionRate;
	}

	public String getTranNr() {
		return tranNr;
	}

	public void setTranNr(String tranNr) {
		this.tranNr = tranNr;
	}

	public boolean isSnknodeReqSysTrace() {
		return snknodeReqSysTrace;
	}

	public void setSnknodeReqSysTrace(boolean snknodeReqSysTrace) {
		this.snknodeReqSysTrace = snknodeReqSysTrace;
	}

	public boolean isSnknodeRevSysTrace() {
		return snknodeRevSysTrace;
	}

	public void setSnknodeRevSysTrace(boolean snknodeRevSysTrace) {
		this.snknodeRevSysTrace = snknodeRevSysTrace;
	}

	public boolean isSnknodeAdvSysTrace() {
		return snknodeAdvSysTrace;
	}

	public void setSnknodeAdvSysTrace(boolean snknodeAdvSysTrace) {
		this.snknodeAdvSysTrace = snknodeAdvSysTrace;
	}

	public boolean isSnknodeAmountRequested() {
		return snknodeAmountRequested;
	}

	public void setSnknodeAmountRequested(boolean snknodeAmountRequested) {
		this.snknodeAmountRequested = snknodeAmountRequested;
	}

}
