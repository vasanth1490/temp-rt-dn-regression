package com.sample.rtdnregression.services;

import java.util.ArrayList;
import java.util.Arrays;
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
			validationEntity.setSrcnodeCashRequested(validateSrcnodeCashRequested(dn, rt)); // 8
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
			validationEntity.setCardAcceptorIdCode(validateCardAcceptorIdCode(dn, rt)); //51
			validationEntity.setCurrencyCodeTran(validateCurrencyCodeTran(dn, rt));
			validationEntity.setMsgReasonCodeReqOut(validateMsgReasonCodeReqOut(dn, rt));// 61
			validationEntity.setMsgReasonCodeRev(validateMsgReasonCodeRev(dn, rt)); // 62
			validationEntity.setMsgReasonCodeAdv(validateMsgReasonCodeAdv(dn, rt)); // 63
			validationEntity.setAbortReason(validateAbortReason(dn, rt));
			validationEntity.setAbortRspCode(validateAbortRspCode(dn, rt));

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

}
