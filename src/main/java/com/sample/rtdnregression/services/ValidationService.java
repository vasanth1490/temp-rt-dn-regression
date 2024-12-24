package com.sample.rtdnregression.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rtdnregression.entities.DNEntity;
import com.sample.rtdnregression.entities.RTEntity;
import com.sample.rtdnregression.entities.ValidationEntity;
import com.sample.rtdnregression.entities.XIstRespRevCodEntity;

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
		List<XIstRespRevCodEntity> istRespRevCodEntities = dnService.getXIstRespRevCod();

//		List<RTEntity> rtEntities = new ArrayList<RTEntity>();
//		List<DNEntity> dnEntities = new ArrayList<DNEntity>();
//		List<XIstRespRevCodEntity> istRespRevCodEntities = new ArrayList<XIstRespRevCodEntity>();

		List<RTEntity> rtEntitiesMT = rtEntities.stream()
				.filter(r -> dnEntities.stream().anyMatch(d -> d.getTranNumber().equals(r.getTranNr())))
				.collect(Collectors.toList());

		List<DNEntity> dnEntitiesMT = dnEntities.stream()
				.filter(d -> rtEntities.stream().anyMatch(r -> r.getTranNr().equals(d.getTranNumber())))
				.collect(Collectors.toList());

		List<RTEntity> rtEntitiesNMT = rtEntities.stream()
				.filter(r -> dnEntities.stream().allMatch(d -> !d.getTranNumber().equals(r.getTranNr())))
				.collect(Collectors.toList());

		List<DNEntity> dnEntitiesNMT = dnEntities.stream()
				.filter(d -> rtEntities.stream().allMatch(r -> !r.getTranNr().equals(d.getTranNumber())))
				.collect(Collectors.toList());

		List<ValidationEntity> validationEntities = new ArrayList<ValidationEntity>();

		Map<String, DNEntity> dnMap = new HashMap<>();
		for (DNEntity dn : dnEntitiesMT) {
			dnMap.put(dn.getTranNumber(), dn);
		}

		for (RTEntity rt : rtEntitiesMT) {
			DNEntity dn = dnMap.get(rt.getTranNr());
			ValidationEntity validationEntity = new ValidationEntity();

			validationEntity.setTranNr(rt.getTranNr());
			validationEntity.setMsgType1(validateMsgType1(dn, rt)); // 1
			validationEntity.setDraftCapture2(validateDraftCapture2(dn, rt)); // 2
			validationEntity.setStandin3(validateStandin3(dn, rt)); // 3
			validationEntity.setSrcnodeDateSettle4(validateSrcnodeDateSettle4(dn, rt)); // 4
			validationEntity.setSrcnodeAmountRequested5(validateSrcnodeAmountRequested5(dn, rt)); // 5
			validationEntity.setSrcnodeCashRequested8(validateSrcnodeCashRequested8(dn, rt)); // 8

			validationEntity.setSrcnodeCurrencyCode11(validateSrcnodeCurrencyCode11(dn, rt)); // 11
			validationEntity.setSrcnodeConversionRate12(validateSrcnodeConversionRate12(dn, rt));// 12
			validationEntity.setSrcnodeDateConversion13(validateSrcnodeDateConversion13(dn, rt));// 13
			validationEntity.setSrcnodeOriginalData14(validateSrcnodeOriginalData14(dn, rt)); // 14
			validationEntity.setSnknodeReqSysTrace15(validateSnknodeReqSysTrace15(dn, rt)); // 15
			validationEntity.setSnknodeRevSysTrace16(validateSnknodeRevSysTrace16(dn, rt));// 16
			validationEntity.setSnknodeAdvSysTrace17(validateSnknodeAdvSysTrace17(dn, rt));// 17
			validationEntity.setSnknodeDateSettle18(validateSnknodeDateSettle18(dn, rt)); // 18
			validationEntity.setSnknodeAmountRequested19(validateSnknodeAmountRequested19(dn, rt)); // 19

			validationEntity.setSnknodeCashRequested22(validateSnknodeCashRequested22(dn, rt)); // 22
			validationEntity.setSnknodeCurrencyCode25(validateSnknodeCurrencyCode25(dn, rt)); // 25
			validationEntity.setSnknodeConversionRate26(validateSnknodeConversionRate26(dn, rt)); // 26
			validationEntity.setSnknodeDateConversion27(validateSnknodeDateConversion27(dn, rt)); // 27
			validationEntity.setTotalsGroup29(validateTotalsGroup29(dn, rt)); // 29
			validationEntity.setTranType30(validateTranType30(dn, rt)); // 30

			validationEntity.setFromAccount31(validateFromAccount31(dn, rt)); // 31
			validationEntity.setToAccount32(validateToAccount32(dn, rt)); // 32
			validationEntity.setAmountTranRequested33(validateAmountTranRequested33(dn, rt)); // 33
			validationEntity.setAmountCashRequested36(validateAmountCashRequested36(dn, rt)); // 36
			validationEntity.setGmtDateTime39(validateGmtDateTime39(dn, rt)); // 39
			validationEntity.setTimeLocal40(validateTimeLocal40(dn, rt)); // 40

			validationEntity.setDateLocal41(validateDateLocal41(dn, rt)); // 41
			validationEntity.setMerchantType43(validateMerchantType43(dn, rt));// 43
			validationEntity.setAcquiringInst44(validateAcquiringInst44(dn, rt)); // 44
			validationEntity.setRspCodeReqRsp47(validateRspCodeReqRsp47(dn, rt, istRespRevCodEntities)); // 47
			validationEntity.setCardAcceptorTermId50(validateCardAcceptorTermId50(dn, rt)); // 50

			validationEntity.setCardAcceptorIdCode51(validateCardAcceptorIdCode51(dn, rt)); // 51
			validationEntity.setCardAcceptorNameLoc52(validateCardAcceptorNameLoc52(dn, rt)); // 52
			validationEntity.setCurrencyCodeTran54(validateCurrencyCodeTran54(dn, rt)); // 54
			validationEntity.setPosDataCode58(validatePosDataCode58(dn, rt)); // 58
			validationEntity.setMsgReasonCodeReqIn60(validateMsgReasonCodeReqIn60(dn, rt)); // 60

			validationEntity.setMsgReasonCodeReqOut61(validateMsgReasonCodeReqOut61(dn, rt));// 61
			validationEntity.setMsgReasonCodeRev62(validateMsgReasonCodeRev62(dn, rt)); // 62
			validationEntity.setMsgReasonCodeAdv63(validateMsgReasonCodeAdv63(dn, rt)); // 63
			validationEntity.setAddrVerificationResult65(validateAddrVerificationResult65(dn, rt)); // 65
			validationEntity.setAbortReason67(validateAbortReason67(dn, rt)); // 67
			validationEntity.setAbortRspCode69(validateAbortRspCode69(dn, rt)); // 69
			validationEntity.setInReq70(validateInReq70(dn, rt)); // 70

			validationEntity.setInAdv72(validateInAdv72(dn, rt)); // 72
			validationEntity.setInRev74(validateInRev74(dn, rt)); // 74

			validationEntity.setSnknodeAcquiringInst87(validateSnknodeAcquiringInst87(dn, rt)); // 87

			validationEntity.setCardVerificationResult91(validateCardVerificationResult91(dn, rt)); // 91
			validationEntity.setSecure3dResult92(validateSecure3dResult92(dn, rt)); // 92
			validationEntity.setUcafData98(validateUcafData98(dn, rt));

			validationEntity.setQueueNumber104(validateQueueNumber104(dn, rt));
			validationEntity.setRetrievalReferenceNumber105(validateRetrievalReferenceNumber105(dn, rt));
			validationEntity.setPanIndicator106(validatePanIndicator106(dn, rt));
			validationEntity.setBinLength107(validateBinLength107(dn, rt));
			validationEntity.setReferenceDataIssuerFormat108(validateReferenceDataIssuerFormat108(dn, rt));

			validationEntities.add(validationEntity);
		}

		excelService.createExcel(rtEntities, dnEntities, validationEntities, istRespRevCodEntities, rtEntitiesNMT,
				dnEntitiesNMT);

	}

	private boolean validateReferenceDataIssuerFormat108(DNEntity dn, RTEntity rt) {
		if(compareStrings(dn.getProcIdIss(), "VISA")) {
			return compareStrings("4", dn.getRefDataIssFmt());
		} else {
			return compareStrings("0", dn.getRefDataIssFmt());
		}
	}

	private boolean validateBinLength107(DNEntity dn, RTEntity rt) {
		if(dn.getPan().length() <= 15) {
			return compareStrings("6", dn.getBinLength());
		} else {
			return compareStrings("8", dn.getBinLength());
		}
	}

	private boolean validatePanIndicator106(DNEntity dn, RTEntity rt) {
		String panIndicator = dn.getPanIndicator();
		String tokenRequestorNo = dn.getTokenRequestorId();

		if (Arrays.asList("VI", "MC", "EH").contains(panIndicator)) {
			return !tokenRequestorNo.isBlank();
		} else {
			return compareStrings(panIndicator, tokenRequestorNo);
		}

	}

	private boolean validateRetrievalReferenceNumber105(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getRetRefNo(), dn.getRetrievalRefNo());
	}

	private boolean validateQueueNumber104(DNEntity dn, RTEntity rt) {
		Map<Integer, List<String>> dnMap = new HashMap<Integer, List<String>>();
		dnMap.put(1, Arrays.asList("QR2", "QR7"));
		dnMap.put(2, Arrays.asList("QR2", "QR7"));
		dnMap.put(3, Arrays.asList("QR2", "QR7"));
		dnMap.put(4, Arrays.asList("QR2", "QR7"));
		dnMap.put(5, Arrays.asList("QR5", "QR8"));
		dnMap.put(6, Arrays.asList("QR5", "QR8"));
		dnMap.put(7, Arrays.asList("QR5", "QR8"));
		dnMap.put(8, Arrays.asList("QR5", "QR8"));
		dnMap.put(9, Arrays.asList("QR6", "QR9"));
		dnMap.put(10, Arrays.asList("QR6", "QR9"));
		dnMap.put(11, Arrays.asList("QR6", "QR9"));
		dnMap.put(12, Arrays.asList("QR6", "QR9"));

		int val = (Integer.valueOf(dn.getTranNumber()) % 12) + 1;
		String tranDesc = dn.getTranDesc().substring(0, 3);
		return dnMap.get(val).contains(tranDesc);
	}

	private boolean validateAddrVerificationResult65(DNEntity dn, RTEntity rt) {
		if (compareStrings("VISA", dn.getProcIdIss())) {
			return compareStrings(null, rt.getAddrVerificationResult()) && dn.getAdlDataPrivIss().length() == 27;
		} else {
			return compareStrings(null, rt.getAddrVerificationResult()) && compareStrings("", dn.getAdlDataPrivIss());
		}
	}

	private boolean validateAmountCashRequested36(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getAmountCashRequested()).intValue());
		if (compareStrings("40", dn.getAdlRqstAmtTyp1())) {
			return compareStrings("5500", rtValue) && compareStrings("5500", dn.getAdlRqstAmt0());
		} else {
			return compareStrings("0", rtValue) && compareStrings("0", dn.getAdlRqstAmt0())
					&& compareStrings("", dn.getAdlRqstAmtTyp1());
		}
	}

	private boolean validateRspCodeReqRsp47(DNEntity dn, RTEntity rt,
			List<XIstRespRevCodEntity> istRespRevCodEntities) {

		String expectedActionCode = null;

		List<XIstRespRevCodEntity> filteredList = istRespRevCodEntities.stream()
				.filter(e -> compareStrings(e.getIstRespRevCode(), rt.getRspCodeReqRsp())).collect(Collectors.toList());

		if (filteredList.size() < 1) {
			return false;
		} else if (filteredList.size() == 1) {
			expectedActionCode = filteredList.get(0).getActionCode();
		} else if (filteredList.size() > 1) {
			if (dn.getMti().equals("1430")) {
				expectedActionCode = filteredList.stream().filter(e -> e.getTranDisposition().equals("3")).findFirst()
						.get().getActionCode();
			} else {
				expectedActionCode = filteredList.get(0).getActionCode();
			}

		}

		return compareStrings(rt.getRspCodeReqRsp(), dn.getExtRspCode())
				&& compareStrings(dn.getActCode(), expectedActionCode);
	}

	private boolean validateUcafData98(DNEntity dn, RTEntity rt) {
		if (rt.getUcafData() == null) {
			return dn.getMciUcafData().trim().length() == 0;
		}
		return true;
	}

	private boolean validatePosDataCode58(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getPosDataCode().substring(0, 1), dn.getPosCrdDatInCap())
				&& compareStrings(rt.getPosDataCode().substring(1, 2), dn.getPosCrdhldrAuthC())
				&& compareStrings(rt.getPosDataCode().substring(2, 3), dn.getPosCardCaptCap())
				&& compareStrings(rt.getPosDataCode().substring(3, 4), dn.getPosOperEnv())
				&& compareStrings(rt.getPosDataCode().substring(4, 5), dn.getPosCrdhldrPresnt())
				&& compareStrings(rt.getPosDataCode().substring(5, 6), dn.getPosCardPres())
				&& compareStrings(rt.getPosDataCode().substring(6, 7), dn.getPosCrdDatInMod())
				&& compareStrings(rt.getPosDataCode().substring(7, 8), dn.getPosCrdhldrAMeth())
				&& compareStrings(rt.getPosDataCode().substring(8, 9), dn.getPosCrdhldrAuth())
				&& compareStrings(rt.getPosDataCode().substring(9, 10), dn.getPosCrdDatOtCap())
				&& compareStrings(rt.getPosDataCode().substring(10, 11), dn.getPosTermOutCap())
				&& compareStrings(rt.getPosDataCode().substring(11, 12), dn.getPosPinCaptCap())
				&& compareStrings(rt.getPosDataCode().substring(12, 13), dn.getPosTermOptr())
				&& compareStrings(rt.getPosDataCode().substring(13, 15), dn.getTermClass());
	}

	private boolean validateCardAcceptorTermId50(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getCardAcceptorTermId(), dn.getCardAcptTermId())
				&& compareStrings(rt.getCardAcceptorTermId(), dn.getNetTermId());
	}

	private boolean validateMsgType1(DNEntity dn, RTEntity rt) {
		int msgType = Integer.valueOf(rt.getMsgType());
		String hex = Integer.toHexString(msgType).toUpperCase();
		String calculatedMti = Integer.toHexString(Integer.parseInt(hex, 16) + Integer.parseInt("1010", 16))
				.toUpperCase();
		calculatedMti = String.valueOf((Integer.valueOf(calculatedMti) / 10) * 10);
		String calculatedFuncCode = Integer.toString((Integer.valueOf(hex) / 100) * 100);
		return calculatedMti.equals(dn.getMti()) && calculatedFuncCode.equals(dn.getFuncCode());
	}

	private boolean validateDraftCapture2(DNEntity dn, RTEntity rt) {
		return dn.getDraftCaptureFlg().equals(rt.getDraftCapture());
	}

	private boolean validateStandin3(DNEntity dn, RTEntity rt) {
		return dn.getStandinAct().equals(rt.getStandIn());
	}

	private boolean validateSrcnodeDateSettle4(DNEntity dn, RTEntity rt) {
		return dn.getDateReconAcq().substring(4).equals(rt.getSrcnodeDateSettle());
	}

	private boolean validateSrcnodeAmountRequested5(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSrcnodeAmountRequested()).intValue());
		if (dn.getMti().equals("1430")) {
			return rtValue.equals(dn.getAmtReconAcq()) && rtValue.equals(dn.getoAmtReconAcq());
		} else {
			return rtValue.equals(dn.getAmtReconAcq());
		}
	}

	private boolean validateSrcnodeCashRequested8(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSrcnodeCashRequested()).intValue());

		if (Integer.valueOf(dn.getAdlRqstAmt1()) > 0) {
			return dn.getAdlRqstAmtTyp1().equals("99");
		} else {
			return rtValue.equals(dn.getAdlRqstAmt1());
		}
	}

	private boolean validateSrcnodeCurrencyCode11(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeCurrencyCode().equals(dn.getCurReconAcq());
	}

	private boolean validateSrcnodeDateConversion13(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeDateConversion().equals(dn.getDateCnvAcq());
	}

	private boolean validateSrcnodeConversionRate12(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeConversionRate().equals(dn.getCnvRcnAcqDePos() + dn.getCnvRcnAcqRate());
	}

	private boolean validateSnknodeReqSysTrace15(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1110", "1210", "1410").contains(dn.getMti())
				? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeReqSysTrace())
				: true;

	}

	private boolean validateSnknodeRevSysTrace16(DNEntity dn, RTEntity rt) {
		return "1430".equals(dn.getMti()) ? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeRevSysTrace()) : true;
	}

	private boolean validateSnknodeAdvSysTrace17(DNEntity dn, RTEntity rt) {
		return "1230".equals(dn.getMti()) ? compareStrings(dn.getSysTraceAuditNo(), rt.getSnknodeAdvSysTrace()) : true;
	}

	private boolean validateSnknodeAmountRequested19(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSnknodeAmountRequested()).intValue());

		if ("1430".equals(dn.getMti())) {
			return rtValue.equals(dn.getAmtReconIss()) && rtValue.equals(dn.getAmtReconNet())
					&& rtValue.equals(dn.getAmtCardBill()) && rtValue.equals(dn.getoAmtCardBill())
					&& rtValue.equals(dn.getoAmtReconIss()) && rtValue.equals(dn.getoAmtReconNet());
		} else {
			return rtValue.equals(dn.getAmtReconIss()) && rtValue.equals(dn.getAmtReconNet())
					&& rtValue.equals(dn.getAmtCardBill());
		}
	}

	private boolean validateSnknodeCashRequested22(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getSnknodeCashRequested()).intValue());

		if (Integer.valueOf(dn.getAdlRespAmt0()) > 0) {
			return dn.getAdlRqstAmtTyp0().equals("40");
		} else {
			return rtValue.equals(dn.getAdlRespAmt0());
		}
	}

	private boolean validateSnknodeCurrencyCode25(DNEntity dn, RTEntity rt) {
		if (rt.getSnknodeCurrencyCode() == null) {
			return dn.getCurReconIss().trim().length() == 0 && dn.getCurReconNet().trim().length() == 0
					&& dn.getCurCardBill().trim().length() == 0;
		} else {
			return rt.getSnknodeCurrencyCode().equals(dn.getCurReconIss())
					&& rt.getSnknodeCurrencyCode().equals(dn.getCurReconNet())
					&& rt.getSnknodeCurrencyCode().equals(dn.getCurCardBill());
		}

	}

	private boolean validateSnknodeConversionRate26(DNEntity dn, RTEntity rt) {
		if (rt.getSnknodeConversionRate() == null) {
			return dn.getCnvRcnIssDePos().equals("0") && dn.getCnvRcnIssRate().equals("0");
		} else {
			return rt.getSnknodeConversionRate().equals(dn.getCnvRcnIssDePos() + dn.getCnvRcnIssRate());
		}

	}

	private boolean validateSnknodeDateConversion27(DNEntity dn, RTEntity rt) {
		return rt.getSnknodeDateConversion() == null ? dn.getDateCnvIss().trim().length() == 0
				: rt.getSnknodeDateConversion().equals(dn.getDateCnvIss());
	}

	private boolean validateTranType30(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getTranType(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(0, 2) : dn.getTranTypeId());
	}

	private boolean validateFromAccount31(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getToAccount(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(2, 4) : dn.getTranTypeId());
	}

	private boolean validateToAccount32(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getToAccount(),
				dn.getTranTypeId() != null ? dn.getTranTypeId().substring(4, 6) : dn.getTranTypeId());
	}

	private boolean validateAmountTranRequested33(DNEntity dn, RTEntity rt) {
		String rtValue = Integer.toString(Double.valueOf(rt.getAmountTranRequested()).intValue());

		if ("1430".equals(dn.getMti())) {
			return compareStrings(rtValue, dn.getAmtTran()) && compareStrings(rtValue, dn.getoAmtTran());
		} else {
			return compareStrings(rtValue, dn.getAmtTran());
		}

	}

	private boolean validateTimeLocal40(DNEntity dn, RTEntity rt) {
		return rt.getTimeLocal().equals(dn.getTstampLocal().substring(8));
	}

	private boolean validateDateLocal41(DNEntity dn, RTEntity rt) {
		return rt.getDateLocal().equals(dn.getTstampLocal().substring(4, 8));
	}

	private boolean validateMerchantType43(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getMerchantType(), dn.getMerchType())
				&& compareStrings(rt.getMerchantType(), dn.getCardAcptBusCode());
	}

	private boolean validateCardAcceptorIdCode51(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getCardAcceptorIdCode(), dn.getCardAcptId())
				&& compareStrings(rt.getCardAcceptorIdCode(), dn.getRptLvlIdB());
	}

	private boolean validateCurrencyCodeTran54(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getCurrencyCodeTran(), dn.getCurTran());
	}

	private boolean validateMsgReasonCodeReqOut61(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1110", "1210", "1410").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeIss(), rt.getMsgReasonCodeReqOut())
				: true;
	}

	private boolean validateMsgReasonCodeRev62(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1430").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeAcq(), rt.getMsgReasonCodeRev())
				: true;
	}

	private boolean validateMsgReasonCodeAdv63(DNEntity dn, RTEntity rt) {
		return Arrays.asList("1230").contains(dn.getMti())
				? compareStrings(dn.getMsgResonCodeAcq(), rt.getMsgReasonCodeAdv())
				: true;
	}

	private boolean validateAbortReason67(DNEntity dn, RTEntity rt) {
		String dnVal = dn.getTranDesc().split("\\|", -1)[2];
		String rtVal = rt.getAbortReason();
		if (rtVal == null) {
			return dnVal.isBlank();
		} else {
			return compareStrings(dnVal, rtVal);
		}
	}

	private boolean validateAbortRspCode69(DNEntity dn, RTEntity rt) {
		String dnVal = dn.getTranDesc().split("\\|", -1)[3];
		String rtVal = rt.getAbortRspCode();
		if (rtVal == null) {
			return dnVal.isBlank();
		} else {
			return compareStrings(dnVal, rtVal);
		}
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

	private boolean validateSrcnodeOriginalData14(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getSrcnodeOriginalData();
		if (rtVal == null) {
			return true;
		} else {
			return compareStrings(rtVal.substring(0, 4).replaceFirst("0", "1"), dn.getOdeMti())
					&& compareStrings(rtVal.substring(4, 10), dn.getOdeSysTraAudNo())
					&& compareStrings(rtVal.substring(10, 20), dn.getOdeTstampLoclTr().substring(4))
					&& compareStrings(rtVal.substring(20, 31), dn.getOdeInstIdAcq());
		}
	}

	private boolean validateSnknodeDateSettle18(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getSnknodeDateSettle();
		if (rtVal == null) {
			rtVal = rt.getSnknodeBatchSettleDate().substring(5, 7) + rt.getSnknodeBatchSettleDate().substring(8, 10);
		}
		return compareStrings(rtVal, dn.getDateReconIss().substring(4))
				&& compareStrings(rtVal, dn.getDateReconNet().substring(4));
	}

	private boolean validateTotalsGroup29(DNEntity dn, RTEntity rt) {
		String rtVal = rt.getTotalsGroup().replaceAll("(?i)1\\s*$", "").toUpperCase();
		return compareStrings(rtVal, dn.getInstIdReconIss().replaceAll("(?i)AU\\s*$", "").toUpperCase())
				&& compareStrings(rtVal, dn.getInstIdRecnIssB().replaceAll("(?i)AU\\s*$", "").toUpperCase());
	}

	private boolean validateGmtDateTime39(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getGmtDateTime(), dn.getGmtTime().substring(4));
	}

	private boolean validateAcquiringInst44(DNEntity dn, RTEntity rt) {
		return rt.getAcquiringInst() == null && dn.getInstIdAcq().trim().isEmpty();
	}

	private boolean validateCardAcceptorNameLoc52(DNEntity dn, RTEntity rt) {
		String rtStoreName = rt.getCardAcceptorNameLoc().substring(0, 23).trim();
		String rtCity = rt.getCardAcceptorNameLoc().substring(23, 36).trim();
		String rtStateCode = String.format("%02d",
				Integer.parseInt(rt.getCardAcceptorNameLoc().substring(36, 38).trim()));
		String rtCountryCode = rt.getCardAcceptorNameLoc().substring(38, 40).trim();

		String dnStoreName = dn.getCardAcptNameLoc().substring(0, 23).trim();
		String dnCity = dn.getCardAcptNameLoc().substring(55).trim();
		String dnStateCode = dn.getCardAcptRegion();
		String dnCountryCode = dn.getCardAcptCountry();

		return compareStrings(rtStoreName, dnStoreName) && compareStrings(rtCity, dnCity)
				&& compareStrings(rtStateCode, dnStateCode) && rtCountryCode.equals("AU")
				&& dnCountryCode.equals("AUS");
	}

	private boolean validateInReq70(DNEntity dn, RTEntity rt) {
		if (Arrays.asList("1110", "1210", "1410").contains(dn.getMti())) {
			String convertedRTVal = null;
			try {
				convertedRTVal = convertDate("yyyy-MM-dd HH:mm:ss.SSS", "yyyyMMddHHmmssSS", rt.getInReq()).substring(0,
						16);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return compareStrings(convertedRTVal, dn.getFinLTstampTrans())
					&& compareStrings(convertedRTVal, dn.getFinRecordTstampTrans());
		}
		return true;
	}

	private boolean validateInAdv72(DNEntity dn, RTEntity rt) {
		if (Arrays.asList("1230").contains(dn.getMti())) {
			String convertedRTVal = null;
			try {
				convertedRTVal = convertDate("yyyy-MM-dd HH:mm:ss.SSS", "yyyyMMddHHmmssSS", rt.getInAdv()).substring(0,
						16);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return compareStrings(convertedRTVal, dn.getFinLTstampTrans())
					&& compareStrings(convertedRTVal, dn.getFinRecordTstampTrans());
		}
		return true;
	}

	private boolean validateInRev74(DNEntity dn, RTEntity rt) {
		if (Arrays.asList("1430").contains(dn.getMti())) {
			String convertedRTVal = null;
			try {
				convertedRTVal = convertDate("yyyy-MM-dd HH:mm:ss.SSS", "yyyyMMddHHmmssSS", rt.getInRev()).substring(0,
						16);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return compareStrings(convertedRTVal, dn.getFinLTstampTrans())
					&& compareStrings(convertedRTVal, dn.getFinRecordTstampTrans());
		}
		return true;
	}

	private boolean validateSnknodeAcquiringInst87(DNEntity dn, RTEntity rt) {
		return compareStrings(rt.getSnknodeAcquiringInst(), dn.getInstIdIss());

	}

	private boolean validateCardVerificationResult91(DNEntity dn, RTEntity rt) {
		return rt.getCardVerificationResult() == null && dn.getCvvCvcResult().trim().isEmpty();
	}

	private boolean validateSecure3dResult92(DNEntity dn, RTEntity rt) {
		return rt.getSecure3dResult() == null && dn.getCavvResult().trim().isEmpty();
	}

	private boolean validateMsgReasonCodeReqIn60(DNEntity dn, RTEntity rt) {
		if (Arrays.asList("1110", "1210", "1410").contains(dn.getMti())) {
			if (rt.getMsgReasonCodeReqIn() == null) {
				return dn.getMsgResonCodeAcq().trim().isEmpty();
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
