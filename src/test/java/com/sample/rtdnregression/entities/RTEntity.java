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
	private String fromAccount;
	private String toAccount;
	private String amountTranRequested;
	private String timeLocal;
	private String dateLocal;
	private String merchantType;
	private String cardAcceptorIdCode;
	private String currencyCodeTran;
	private String msgReasonCodeReqOut;
	private String msgReasonCodeRev;
	private String msgReasonCodeAdv;
	private String abortReason;
	private String abortRspCode;
	private String srcnodeOriginalData;
	private String snknodeDateSettle;
	private String snknodeBatchSettleDate;
	private String totalsGroup;
	private String gmtDateTime;
	private String acquiringInst;
	private String rspCodeReqRsp;
	private String cardAcceptorNameLoc;
	private String inReq;
	private String inAdv;
	private String inRev;
	private String snknodeAcquiringInst;
	private String cardVerificationResult;
	private String secure3dResult;
	private String msgReasonCodeReqIn;

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

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getCardAcceptorIdCode() {
		return cardAcceptorIdCode;
	}

	public void setCardAcceptorIdCode(String cardAcceptorIdCode) {
		this.cardAcceptorIdCode = cardAcceptorIdCode;
	}

	public String getCurrencyCodeTran() {
		return currencyCodeTran;
	}

	public void setCurrencyCodeTran(String currencyCodeTran) {
		this.currencyCodeTran = currencyCodeTran;
	}

	public String getMsgReasonCodeReqOut() {
		return msgReasonCodeReqOut;
	}

	public void setMsgReasonCodeReqOut(String msgReasonCodeReqOut) {
		this.msgReasonCodeReqOut = msgReasonCodeReqOut;
	}

	public String getMsgReasonCodeRev() {
		return msgReasonCodeRev;
	}

	public void setMsgReasonCodeRev(String msgReasonCodeRev) {
		this.msgReasonCodeRev = msgReasonCodeRev;
	}

	public String getMsgReasonCodeAdv() {
		return msgReasonCodeAdv;
	}

	public void setMsgReasonCodeAdv(String msgReasonCodeAdv) {
		this.msgReasonCodeAdv = msgReasonCodeAdv;
	}

	public String getAbortReason() {
		return abortReason;
	}

	public void setAbortReason(String abortReason) {
		this.abortReason = abortReason;
	}

	public String getAbortRspCode() {
		return abortRspCode;
	}

	public void setAbortRspCode(String abortRspCode) {
		this.abortRspCode = abortRspCode;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getSrcnodeOriginalData() {
		return srcnodeOriginalData;
	}

	public void setSrcnodeOriginalData(String srcnodeOriginalData) {
		this.srcnodeOriginalData = srcnodeOriginalData;
	}

	public String getSnknodeDateSettle() {
		return snknodeDateSettle;
	}

	public void setSnknodeDateSettle(String snknodeDateSettle) {
		this.snknodeDateSettle = snknodeDateSettle;
	}

	public String getTotalsGroup() {
		return totalsGroup;
	}

	public void setTotalsGroup(String totalsGroup) {
		this.totalsGroup = totalsGroup;
	}

	public String getGmtDateTime() {
		return gmtDateTime;
	}

	public void setGmtDateTime(String gmtDateTime) {
		this.gmtDateTime = gmtDateTime;
	}

	public String getAcquiringInst() {
		return acquiringInst;
	}

	public void setAcquiringInst(String acquiringInst) {
		this.acquiringInst = acquiringInst;
	}

	public String getRspCodeReqRsp() {
		return rspCodeReqRsp;
	}

	public void setRspCodeReqRsp(String rspCodeReqRsp) {
		this.rspCodeReqRsp = rspCodeReqRsp;
	}

	public String getCardAcceptorNameLoc() {
		return cardAcceptorNameLoc;
	}

	public void setCardAcceptorNameLoc(String cardAcceptorNameLoc) {
		this.cardAcceptorNameLoc = cardAcceptorNameLoc;
	}

	public String getInReq() {
		return inReq;
	}

	public void setInReq(String inReq) {
		this.inReq = inReq;
	}

	public String getInAdv() {
		return inAdv;
	}

	public void setInAdv(String inAdv) {
		this.inAdv = inAdv;
	}

	public String getInRev() {
		return inRev;
	}

	public void setInRev(String inRev) {
		this.inRev = inRev;
	}

	public String getSnknodeAcquiringInst() {
		return snknodeAcquiringInst;
	}

	public void setSnknodeAcquiringInst(String snknodeAcquiringInst) {
		this.snknodeAcquiringInst = snknodeAcquiringInst;
	}

	public String getCardVerificationResult() {
		return cardVerificationResult;
	}

	public void setCardVerificationResult(String cardVerificationResult) {
		this.cardVerificationResult = cardVerificationResult;
	}

	public String getSecure3dResult() {
		return secure3dResult;
	}

	public void setSecure3dResult(String secure3dResult) {
		this.secure3dResult = secure3dResult;
	}

	public String getSnknodeBatchSettleDate() {
		return snknodeBatchSettleDate;
	}

	public void setSnknodeBatchSettleDate(String snknodeBatchSettleDate) {
		this.snknodeBatchSettleDate = snknodeBatchSettleDate;
	}

	public String getMsgReasonCodeReqIn() {
		return msgReasonCodeReqIn;
	}

	public void setMsgReasonCodeReqIn(String msgReasonCodeReqIn) {
		this.msgReasonCodeReqIn = msgReasonCodeReqIn;
	}

}
