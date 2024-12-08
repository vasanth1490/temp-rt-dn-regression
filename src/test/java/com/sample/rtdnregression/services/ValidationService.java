package com.sample.rtdnregression.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rtdnregression.entities.DNEntity;
import com.sample.rtdnregression.entities.RTEntity;
import com.sample.rtdnregression.entities.ValidationEntity;

@Service
public class ValidationService {

	@Autowired
	private RTService rtService;

	@Autowired
	private DNService dnService;

	@Autowired
	private ExcelReportService excelService;

	public void validation() {
		List<RTEntity> rtEntities = rtService.getRTData();
		List<DNEntity> dnEntities = dnService.getDNData();
		List<ValidationEntity> validationEntities = new ArrayList<ValidationEntity>();

		Map<String, DNEntity> dnMap = new HashMap<>();
		for (DNEntity dn : dnEntities) {
			dnMap.put(dn.getTranNumber(), dn);
		}

		for (RTEntity rt : rtEntities) {
			DNEntity dn = dnMap.get(rt.getTranNr());
			ValidationEntity validationEntity = new ValidationEntity();

			validationEntity.setTranNr(rt.getTranNr());
			validationEntity.setMsgType(validateMsgType(dn, rt)); // 1
			validationEntity.setDraftCapture(validateDraftCapture(dn, rt)); // 2
			validationEntity.setStandin(validateStandin(dn, rt)); // 3
			validationEntity.setSrcnodeDateSettle(validateSrcnodeDateSettle(dn, rt)); // 4
			validationEntity.setSrcnodeAmountRequested(validateSrcnodeAmountRequested(dn, rt)); // 5
			// 6 7 No Mapping
			validationEntity.setSrcnodeCashRequested(validateSrcnodeCashRequested(dn, rt)); // 8
			// 9 10 No Mapping
			validationEntity.setSrcnodeCurrencyCode(validateSrcnodeCurrencyCode(dn, rt)); // 11
			validationEntity.setSrcnodeConversionRate(validateSrcnodeConversionRate(dn, rt));// 12
			validationEntity.setSrcnodeDateConversion(validateSrcnodeDateConversion(dn, rt));// 13
			validationEntity.setSnknodeReqSysTrace(validateSnknodeReqSysTrace(dn, rt)); // 15
			validationEntity.setSnknodeRevSysTrace(validateSnknodeRevSysTrace(dn, rt));// 16
			validationEntity.setSnknodeAdvSysTrace(validateSnknodeAdvSysTrace(dn, rt));// 17
			validationEntity.setSnknodeAmountRequested(validateSnknodeAmountRequested(dn, rt)); // 19
			validationEntity.setSnknodeCashRequested(validateSnknodeCashRequested(dn, rt)); // 22
			validationEntity.setSnknodeCurrencyCode(validateSnknodeCurrencyCode(dn, rt)); // 25
			validationEntity.setSnknodeConversionRate(validateSnknodeConversionRate(dn, rt)); // 26
			validationEntity.setSnknodeDateConversion(validateSnknodeDateConversion(dn, rt)); // 27
			validationEntity.setTranType(validateTranType(dn, rt)); // 30
			validationEntity.setFromAccount(validateFromAccount(dn, rt)); // 31
			validationEntity.setToAccount(validateToAccount(dn, rt)); // 32
			validationEntity.setAmountTranRequested(validateAmountTranRequested(dn, rt)); // 33
			validationEntity.setTimeLocal(validateTimeLocal(dn, rt)); // 40
			validationEntity.setDateLocal(validateDateLocal(dn, rt)); // 41
			validationEntity.setMerchantType(validateMerchantType(dn, rt));// 43
			validationEntity.setCardAcceptorIdCode(validateCardAcceptorIdCode(dn, rt)); // 51
			validationEntity.setCurrencyCodeTran(validateCurrencyCodeTran(dn, rt)); // 54
			validationEntity.setMsgReasonCodeReqOut(validateMsgReasonCodeReqOut(dn, rt));// 61
			validationEntity.setMsgReasonCodeRev(validateMsgReasonCodeRev(dn, rt)); // 62
			validationEntity.setMsgReasonCodeAdv(validateMsgReasonCodeAdv(dn, rt)); // 63
			validationEntity.setAbortReason(validateAbortReason(dn, rt)); // 67
			validationEntity.setAbortRspCode(validateAbortRspCode(dn, rt)); // 69

			validationEntity.setSrcnodeOriginalData(validateSrcnodeOriginalData(dn, rt)); // 14
			validationEntity.setSnknodeDateSettle(validateSnknodeDateSettle(dn, rt)); // 18
			validationEntity.setTotalsGroup(validateTotalsGroup(dn, rt)); // 29
			validationEntity.setGmtDateTime(validateGmtDateTime(dn, rt)); // 39
			validationEntity.setAcquiringInst(validateAcquiringInst(dn, rt)); // 44
			validationEntity.setRspCodeReqRsp(validateRspCodeReqRsp(dn, rt));
			validationEntity.setCardAcceptorNameLoc(validateCardAcceptorNameLoc(dn, rt)); // 52
			validationEntity.setInReq(validateInReq(dn, rt));
			validationEntity.setInAdv(validateInAdv(dn, rt));
			validationEntity.setInRev(validateInRev(dn, rt));
			validationEntity.setSnknodeAcquiringInst(validateSnknodeAcquiringInst(dn, rt)); // 87
			validationEntity.setCardVerificationResult(validateCardVerificationResult(dn, rt)); // 91
			validationEntity.setSecure3dResult(validateSecure3dResult(dn, rt)); // 92
			validationEntity.setMsgReasonCodeReqIn(validateMsgReasonCodeReqIn(dn, rt)); // 60

			validationEntities.add(validationEntity);
		}

		excelService.createExcel(rtEntities, dnEntities, validationEntities);

	}

	private boolean validateMsgType(DNEntity dn, RTEntity rt) {
		int msgType = Integer.valueOf(rt.getMsgType());
		String hex = Integer.toHexString(msgType).toUpperCase();
		String calculatedMti = Integer.toHexString(Integer.parseInt(hex, 16) + Integer.parseInt("1010", 16))
				.toUpperCase();
		calculatedMti = String.valueOf((Integer.valueOf(calculatedMti) / 10) * 10);
		String calculatedFuncCode = Integer.toString((Integer.valueOf(hex) / 100) * 100);
		return calculatedMti.equals(dn.getMti()) && calculatedFuncCode.equals(dn.getFuncCode());
	}

	private boolean validateDraftCapture(DNEntity dn, RTEntity rt) {
		return dn.getDraftCaptureFlg().equals(rt.getDraftCapture());
	}

	private boolean validateStandin(DNEntity dn, RTEntity rt) {
		return dn.getStandinAct().equals(rt.getStandIn());
	}

	private boolean validateSrcnodeDateSettle(DNEntity dn, RTEntity rt) {
		return dn.getDateReconAcq().substring(4).equals(rt.getSrcnodeDateSettle());
	}

	private boolean validateSrcnodeAmountRequested(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSrcnodeAmountRequested()).intValue());
		if (dn.getMti().equals("1430")) {
			return rtValue.equals(dn.getAmtReconAcq()) && rtValue.equals(dn.getoAmtReconAcq());
		} else {
			return rtValue.equals(dn.getAmtReconAcq());
		}
	}

	private boolean validateSrcnodeCashRequested(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSrcnodeCashRequested()).intValue());

		if (Integer.valueOf(dn.getAdlRqstAmt1()) > 0) {
			return dn.getAdlRqstAmtTyp1().equals("99");
		} else {
			return rtValue.equals(dn.getAdlRqstAmt1());
		}
	}

	private boolean validateSrcnodeCurrencyCode(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeCurrencyCode().equals(dn.getCurReconAcq());
	}

	private boolean validateSrcnodeDateConversion(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeDateConversion().equals(dn.getDateCnvAcq());
	}

	private boolean validateSrcnodeConversionRate(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeConversionRate().equals(dn.getCnvRcnAcqDePos() + dn.getCnvRcnAcqRate());
	}

	private boolean validateSnknodeReqSysTrace(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1110", "1210", "1410").contains(dn.getMti())
				? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeReqSysTrace())
				: true;

	}

	private boolean validateSnknodeRevSysTrace(DNEntity dn, RTEntity rt) {
		return "1430".equals(dn.getMti()) ? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeRevSysTrace()) : true;
	}

	private boolean validateSnknodeAdvSysTrace(DNEntity dn, RTEntity rt) {
		return "1230".equals(dn.getMti()) ? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeAdvSysTrace()) : true;
	}

	private boolean validateSnknodeAmountRequested(DNEntity dn, RTEntity rt) {
		if ("1430".equals(dn.getMti())) {
			return rt.getSnknodeAmountRequested().equals(dn.getAmtReconIss())
					&& rt.getSnknodeAmountRequested().equals(dn.getAmtReconNet())
					&& rt.getSnknodeAmountRequested().equals(dn.getAmtCardBill())
					&& rt.getSnknodeAmountRequested().equals(dn.getoAmtCardBill())
					&& rt.getSnknodeAmountRequested().equals(dn.getoAmtReconIss())
					&& rt.getSnknodeAmountRequested().equals(dn.getoAmtReconNet());
		} else {
			return rt.getSnknodeAmountRequested().equals(dn.getAmtReconIss())
					&& rt.getSnknodeAmountRequested().equals(dn.getAmtReconNet())
					&& rt.getSnknodeAmountRequested().equals(dn.getAmtCardBill());
		}
	}

	private boolean validateSnknodeCashRequested(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSnknodeCashRequested()).intValue());

		if (Integer.valueOf(dn.getAdlRespAmt0()) > 0) {
			return dn.getAdlRqstAmtTyp0().equals("40");
		} else {
			return rtValue.equals(dn.getAdlRespAmt0());
		}
	}

	private boolean validateSnknodeCurrencyCode(DNEntity dn, RTEntity rt) {
		if (rt.getSnknodeCurrencyCode() == null) {
			return dn.getCurReconIss().trim().length() == 0 && dn.getCurReconNet().trim().length() == 0
					&& dn.getCurCardBill().trim().length() == 0;
		} else {
			return rt.getSnknodeCurrencyCode().equals(dn.getCurReconIss())
					&& rt.getSnknodeCurrencyCode().equals(dn.getCurReconNet())
					&& rt.getSnknodeCurrencyCode().equals(dn.getCurCardBill());
		}

	}

	private boolean validateSnknodeConversionRate(DNEntity dn, RTEntity rt) {
		if (rt.getSnknodeConversionRate() == null) {
			return dn.getCnvRcnIssDePos().equals("0") && dn.getCnvRcnIssRate().equals("0");
		} else {
			return rt.getSnknodeConversionRate().equals(dn.getCnvRcnIssDePos() + dn.getCnvRcnIssRate());
		}

	}

	private boolean validateSnknodeDateConversion(DNEntity dn, RTEntity rt) {
		return rt.getSnknodeDateConversion() == null ? dn.getDateCnvIss().trim().length() == 0
				: rt.getSnknodeDateConversion().equals(dn.getDateCnvIss());
	}

	private boolean validateTranType(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getTranType(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(0, 2) : dn.getTranTypeId());
	}

	private boolean validateFromAccount(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getToAccount(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(2, 4) : dn.getTranTypeId());
	}

	private boolean validateToAccount(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getToAccount(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(4, 6) : dn.getTranTypeId());
	}

	private boolean validateAmountTranRequested(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getAmountTranRequested()).intValue());

		if ("1430".equals(dn.getMti())) {
			return compareStrings(rtValue, dn.getAmtTran()) && compareStrings(rtValue, dn.getoAmtTran());
		} else {
			return compareStrings(rtValue, dn.getAmtTran());
		}

	}

	private boolean validateTimeLocal(DNEntity dn, RTEntity rt) {
		return rt.getTimeLocal().equals(dn.getTstampLocal().substring(8));
	}

	private boolean validateDateLocal(DNEntity dn, RTEntity rt) {
		return rt.getDateLocal().equals(dn.getTstampLocal().substring(4, 8));
	}

	private boolean validateMerchantType(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getMerchantType(), dn.getMerchType())
				&& compareStrings(rt.getMerchantType(), dn.getCardAcptBusCode());
	}

	private boolean validateCardAcceptorIdCode(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getCardAcceptorIdCode(), dn.getCardAcptId())
				&& compareStrings(rt.getCardAcceptorIdCode(), dn.getRptLvlIdB());
	}

	private boolean validateCurrencyCodeTran(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getCurrencyCodeTran(), dn.getCurTran());
	}

	private boolean validateMsgReasonCodeReqOut(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1110", "1210", "1410").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeIss(), rt.getMsgReasonCodeReqOut())
				: true;
	}

	private boolean validateMsgReasonCodeRev(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1430").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeAcq(), rt.getMsgReasonCodeRev())
				: true;
	}

	private boolean validateMsgReasonCodeAdv(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1230").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeAcq(), rt.getMsgReasonCodeAdv())
				: true;
	}

	private boolean validateAbortReason(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getAbortReason(), dn.getTranDesc().split("|")[2]);
	}

	private boolean validateAbortRspCode(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getAbortRspCode(), dn.getTranDesc().split("|")[3]);
	}

	private boolean compareStrings(String a, String b) {
		if (a != null) {
			a = a.trim();
		}
		if (b != null) {
			b = b.trim();
		}

		return a == b || (a != null && a.equals(b));
	}

	private boolean validateSrcnodeOriginalData(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getSrcnodeOriginalData();
		if (rtVal == null) {
			return true;
		} else {
			return compareStrings(rtVal.substring(0, 4).replaceFirst("0", "1"), dn.getOdeMti())
					&& compareStrings(rtVal.substring(4, 10), dn.getOdeSysTraAudNo())
					&& compareStrings(rtVal.substring(10, 20), dn.getOdeTstampLoclTr().substring(4))
					&& compareStrings(rtVal.substring(20, 31), dn.getOdeInstIsAcq());
		}
	}

	private boolean validateSnknodeDateSettle(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getSnknodeDateSettle();
		if (rtVal == null) {
			rtVal = rt.getSnknodeBatchSettleDate().substring(5, 7) + rt.getSnknodeBatchSettleDate().substring(8, 10);
		}
		return compareStrings(rtVal, dn.getDateReconIss().substring(4))
				&& compareStrings(rtVal, dn.getDateReconNet().substring(4));
	}

	private boolean validateTotalsGroup(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getTotalsGroup().replaceAll("(?i)1$", "").toUpperCase();
		return compareStrings(rtVal, dn.getInstIdReconIss().replaceAll("(?i)AU$", "").toUpperCase())
				&& compareStrings(rtVal, dn.getInstIdRecnIssB().replaceAll("(?i)AU$", "").toUpperCase());
	}

	private boolean validateGmtDateTime(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getGmtDateTime(), dn.getGmtTime().substring(4));
	}

	private boolean validateAcquiringInst(DNEntity dn, RTEntity rt) {
		return rt.getAcquiringInst() == null && dn.getInstIdAcq().isEmpty();
	}

	private boolean validateRspCodeReqRsp(DNEntity dn, RTEntity rt) {

		// Add your validation logic here
		return false;
	}

	private boolean validateCardAcceptorNameLoc(DNEntity dn, RTEntity rt) {
		String rtStoreName = rt.getCardAcceptorNameLoc().substring(0, 23).trim();
		String rtCity = rt.getCardAcceptorNameLoc().substring(23, 36).trim();
		String rtStateCode = String.format("%03d",
				Integer.parseInt(rt.getCardAcceptorNameLoc().substring(36, 38).trim()));
		String rtCountryCode = rt.getCardAcceptorNameLoc().substring(38, 40).trim();

		String dnStoreName = dn.getCardAcptNameLoc().substring(0, 23).trim();
		String dnCity = dn.getCardAcptNameLoc().substring(55, 68).trim();
		String dnStateCode = dn.getCardAcptRegion();
		String dnCountryCode = dn.getCardAcptCountry();

		return compareStrings(rtStoreName, dnStoreName) && compareStrings(rtCity, dnCity)
				&& compareStrings(rtStateCode, dnStateCode) && rtCountryCode.equals("AU")
				&& dnCountryCode.equals("AUS");
	}

	private boolean validateInReq(DNEntity dn, RTEntity rt) {
//		if (Arrays.asList("1110", "1210", "1410").contains(dn.getMti())) {
//			String convertedRTVal = convertDate("yyyy-MM-dd HH:mm:ss.SSS", "yyyyMMddHHmmssSS", rt.getInReq()).substring(0,16);
//			return compareStrings(convertedRTVal, dn.getTst);
//		}
		return false;
	}

	private boolean validateInAdv(DNEntity dn, RTEntity rt) {
		// Add your validation logic here
		return false;
	}

	private boolean validateInRev(DNEntity dn, RTEntity rt) {
		// Add your validation logic here
		return false;
	}

	private boolean validateSnknodeAcquiringInst(DNEntity dn, RTEntity rt) {
		return rt.getSnknodeAcquiringInst() == null && dn.getInstIdIss().isEmpty();
	}

	private boolean validateCardVerificationResult(DNEntity dn, RTEntity rt) {
		return rt.getCardVerificationResult() == null && dn.getCvvCvcResult().isEmpty();
	}

	private boolean validateSecure3dResult(DNEntity dn, RTEntity rt) {
		return rt.getSecure3dResult() == null && dn.getCavvResult().isEmpty();
	}

	private boolean validateMsgReasonCodeReqIn(DNEntity dn, RTEntity rt) {
		if (Arrays.asList("1110", "1210", "1410").contains(dn.getMti())) {
			if (rt.getMsgReasonCodeReqIn() == null) {
				return dn.getMsgResonCodeAcq().isEmpty();
			} else {
				return compareStrings(rt.getMsgReasonCodeReqIn(), dn.getMsgResonCodeAcq());
			}
		}
		return true;
	}
	
	private String convertDate(String srcFormat, String destFormat, String dateStr) throws ParseException {
		SimpleDateFormat srcDateFormat = new SimpleDateFormat(srcFormat);
		Date date = srcDateFormat.parse(dateStr);
		SimpleDateFormat destDateFormat = new SimpleDateFormat(destFormat);
		return destDateFormat.format(date);
	}

}
