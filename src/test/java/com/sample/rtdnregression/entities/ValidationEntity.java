package com.sample.rtdnregression.entities;

public class ValidationEntity {
	private String transactionId;
	private boolean msgType;
	private boolean draftCapture;
	private boolean standin;
	private boolean srcnodeDateSettle;
	private boolean srcnodeAmountRequested;
	private boolean srcnodeCashRequested;
	private boolean srcnodeCurrencyCode;
	private boolean srcnodeDateConversion;
	private boolean srcnodeConversionRate;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

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

}
