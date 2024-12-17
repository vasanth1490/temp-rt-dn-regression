package com.sample.rtdnregression.services;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sample.rtdnregression.Constants;
import com.sample.rtdnregression.entities.DNEntity;
import com.sample.rtdnregression.entities.RTEntity;
import com.sample.rtdnregression.entities.ValidationEntity;
import com.sample.rtdnregression.entities.XIstRespRevCodEntity;
import com.sample.rtdnregression.models.StyleKey;

@Service
public class ExcelReportService {

	public void createExcel(List<RTEntity> rtEntities, List<DNEntity> dnEntities,
			List<ValidationEntity> validationEntities, List<XIstRespRevCodEntity> istRespRevCodEntities,
			List<RTEntity> rtEntitiesNMT, List<DNEntity> dnEntitiesNMT) {
		String fileName = "result.xlsx";

		try (Workbook workbook = new XSSFWorkbook()) {
			Map<StyleKey, CellStyle> stylesMap = getStyles(workbook);
			createRTSheet(workbook, rtEntities, stylesMap);
			createDNSheet(workbook, dnEntities, stylesMap);
			createIstRespRevCodSheet(workbook, istRespRevCodEntities, stylesMap);
			createNotMatchingTrans(workbook, rtEntitiesNMT, dnEntitiesNMT, stylesMap);
			createValidationSheet(workbook, validationEntities, stylesMap);

			try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
				workbook.write(fileOut);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createNotMatchingTrans(Workbook workbook, List<RTEntity> rtEntitiesNMT, List<DNEntity> dnEntitiesNMT,
			Map<StyleKey, CellStyle> stylesMap) {
		Sheet sheet = workbook.createSheet("NotMatchingTrans");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.nmtHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.nmtHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= rtEntitiesNMT.size(); j++) {
			Row dataRow = sheet.createRow(j);

			RTEntity entity = rtEntitiesNMT.get(j - 1);

			Map<String, String> nmtMap = new HashMap<String, String>();
			nmtMap.put(Constants.NMT_TRAN_NUMBER, entity.getTranNr());
			nmtMap.put(Constants.NMT_DB, "RT");

			for (int x = 0; x < Constants.nmtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				cell.setCellValue(nmtMap.get(Constants.nmtHeaders.get(x)));
			}
		}

		for (int j = 1; j <= dnEntitiesNMT.size(); j++) {
			Row dataRow = sheet.createRow(j);

			DNEntity entity = dnEntitiesNMT.get(j - 1);

			Map<String, String> nmtMap = new HashMap<String, String>();
			nmtMap.put(Constants.NMT_TRAN_NUMBER, entity.getTranNumber());
			nmtMap.put(Constants.NMT_DB, "DN");

			for (int x = 0; x < Constants.nmtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				cell.setCellValue(nmtMap.get(Constants.nmtHeaders.get(x)));
			}
		}
	}

	private void createIstRespRevCodSheet(Workbook workbook, List<XIstRespRevCodEntity> istRespRevCodEntities,
			Map<StyleKey, CellStyle> stylesMap) {
		Sheet sheet = workbook.createSheet("IstRespRevCod");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.istRespRevCodHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.istRespRevCodHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= istRespRevCodEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			XIstRespRevCodEntity entity = istRespRevCodEntities.get(j - 1);

			Map<String, Object> dnMap = new HashMap<String, Object>();
			dnMap.put(Constants.DN_TRAN_DISPOSITION, entity.getTranDisposition());
			dnMap.put(Constants.DN_ACTION_CODE, entity.getActionCode());
			dnMap.put(Constants.DN_IST_RESP_REV_CODE, entity.getIstRespRevCode());

			for (int x = 0; x < Constants.istRespRevCodHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));

				String value = (String) dnMap.get(Constants.istRespRevCodHeaders.get(x));
				value = value != null ? value.trim() : value;
				if (isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					cell.setCellValue(Long.valueOf(value));
				}
			}
		}
	}

	private void createRTSheet(Workbook workbook, List<RTEntity> rtEntities, Map<StyleKey, CellStyle> stylesMap) {

		Sheet sheet = workbook.createSheet("rt");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.rtHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.rtHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= rtEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			RTEntity rtEntity = rtEntities.get(j - 1);

			Map<String, Object> rtMap = new HashMap<String, Object>();
			rtMap.put(Constants.RT_NAME, rtEntity.getRtName());
			rtMap.put(Constants.RT_TRAN_NR, rtEntity.getTranNr());
			rtMap.put(Constants.RT_MSG_TYPE, rtEntity.getMsgType());
			rtMap.put(Constants.RT_DRAFT_CAPTURE, rtEntity.getDraftCapture());
			rtMap.put(Constants.RT_STAND_IN, rtEntity.getStandIn());
			rtMap.put(Constants.RT_SRCNODE_DATE_SETTLE, rtEntity.getSrcnodeDateSettle());
			rtMap.put(Constants.RT_SRCNODE_AMOUNT_REQUESTED, rtEntity.getSrcnodeAmountRequested());
			rtMap.put(Constants.RT_SRCNODE_CASH_REQUESTED, rtEntity.getSrcnodeCashRequested());
			rtMap.put(Constants.RT_SRCNODE_CURRENCY_CODE, rtEntity.getSrcnodeCurrencyCode());
			rtMap.put(Constants.RT_SRCNODE_DATE_CONVERSION, rtEntity.getSrcnodeDateConversion());
			rtMap.put(Constants.RT_SRCNODE_CONVERSION_RATE, rtEntity.getSrcnodeConversionRate());
			rtMap.put(Constants.RT_SNKNODE_REQ_SYS_TRACE, rtEntity.getSnknodeReqSysTrace());
			rtMap.put(Constants.RT_SNKNODE_REV_SYS_TRACE, rtEntity.getSnknodeRevSysTrace());
			rtMap.put(Constants.RT_SNKNODE_ADV_SYS_TRACE, rtEntity.getSnknodeAdvSysTrace());
			rtMap.put(Constants.RT_SNKNODE_AMOUNT_REQUESTED, rtEntity.getSnknodeAmountRequested());
			rtMap.put(Constants.RT_SNKNODE_CASH_REQUESTED, rtEntity.getSnknodeCashRequested());
			rtMap.put(Constants.RT_SNKNODE_CURRENCY_CODE, rtEntity.getSnknodeCurrencyCode());
			rtMap.put(Constants.RT_SNKNODE_CONVERSION_RATE, rtEntity.getSnknodeConversionRate());
			rtMap.put(Constants.RT_SNKNODE_DATE_CONVERSION, rtEntity.getSnknodeDateConversion());
			rtMap.put(Constants.RT_TRAN_TYPE, rtEntity.getTranType());
			rtMap.put(Constants.RT_TO_ACCOUNT, rtEntity.getToAccount());
			rtMap.put(Constants.RT_AMOUNT_TRAN_REQUESTED, rtEntity.getAmountTranRequested());
			rtMap.put(Constants.RT_TIME_LOCAL, rtEntity.getTimeLocal());
			rtMap.put(Constants.RT_DATE_LOCAL, rtEntity.getDateLocal());
			rtMap.put(Constants.RT_MERCHANT_TYPE, rtEntity.getMerchantType());
			rtMap.put(Constants.RT_CARD_ACCEPTOR_ID_CODE, rtEntity.getCardAcceptorIdCode());
			rtMap.put(Constants.RT_CURRENCY_CODE_TRAN, rtEntity.getCurrencyCodeTran());
			rtMap.put(Constants.RT_MSG_REASON_CODE_REQ_OUT, rtEntity.getMsgReasonCodeReqOut());
			rtMap.put(Constants.RT_MSG_REASON_CODE_REV, rtEntity.getMsgReasonCodeRev());
			rtMap.put(Constants.RT_MSG_REASON_CODE_ADV, rtEntity.getMsgReasonCodeAdv());
			rtMap.put(Constants.RT_ABORT_REASON, rtEntity.getAbortReason());
			rtMap.put(Constants.RT_ABORT_RSP_CODE, rtEntity.getAbortRspCode());
			rtMap.put(Constants.RT_SRCNODE_ORIGINAL_DATA, rtEntity.getSrcnodeOriginalData());
			rtMap.put(Constants.RT_SNKNODE_DATE_SETTLE, rtEntity.getSnknodeDateSettle());
			rtMap.put(Constants.RT_TOTALS_GROUP, rtEntity.getTotalsGroup());
			rtMap.put(Constants.RT_GMT_DATE_TIME, rtEntity.getGmtDateTime());
			rtMap.put(Constants.RT_ACQUIRING_INST, rtEntity.getAcquiringInst());
			rtMap.put(Constants.RT_RSP_CODE_REQ_RSP, rtEntity.getRspCodeReqRsp());
			rtMap.put(Constants.RT_CARD_ACCEPTOR_NAME_LOC, rtEntity.getCardAcceptorNameLoc());
			rtMap.put(Constants.RT_IN_REQ, rtEntity.getInReq());
			rtMap.put(Constants.RT_IN_ADV, rtEntity.getInAdv());
			rtMap.put(Constants.RT_IN_REV, rtEntity.getInRev());
			rtMap.put(Constants.RT_SNKNODE_ACQUIRING_INST, rtEntity.getSnknodeAcquiringInst());
			rtMap.put(Constants.RT_CARD_VERIFICATION_RESULT, rtEntity.getCardVerificationResult());
			rtMap.put(Constants.RT_SECURE_3D_RESULT, rtEntity.getSecure3dResult());

			rtMap.put(Constants.RT_MSG_REASON_CODE_REQ_IN, rtEntity.getMsgReasonCodeReqIn());
			rtMap.put(Constants.RT_CARD_ACCEPTOR_TERM_ID, rtEntity.getCardAcceptorTermId());
			rtMap.put(Constants.RT_POS_DATA_CODE, rtEntity.getPosDataCode());
			rtMap.put(Constants.RT_UCAF_DATA, rtEntity.getUcafData());
			rtMap.put(Constants.RT_AMOUNT_CASH_REQUESTED, rtEntity.getAmountCashRequested());
			rtMap.put(Constants.RT_ADDR_VERIFICATION_RESULT, rtEntity.getAddrVerificationResult());

			for (int x = 0; x < Constants.rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));

				String value = (String) rtMap.get(Constants.rtHeaders.get(x));
				if (isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					try {
						cell.setCellValue(Integer.valueOf(value));
					} catch (NumberFormatException e) {
						cell.setCellValue(Double.parseDouble(value));
					}

				}
			}
		}

	}

	private void createDNSheet(Workbook workbook, List<DNEntity> dnEntities, Map<StyleKey, CellStyle> stylesMap) {

		Sheet sheet = workbook.createSheet("dn");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.dnHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.dnHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= dnEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			DNEntity dnEntity = dnEntities.get(j - 1);

			Map<String, Object> dnMap = new HashMap<String, Object>();
			dnMap.put(Constants.DN_TRAN_NUMBER, dnEntity.getTranNumber());
			dnMap.put(Constants.DN_MTI, dnEntity.getMti());
			dnMap.put(Constants.DN_FUNC_CODE, dnEntity.getFuncCode());
			dnMap.put(Constants.DN_DRAFT_CAPTURE_FLG, dnEntity.getDraftCaptureFlg());
			dnMap.put(Constants.DN_STANDIN_ACT, dnEntity.getStandinAct());
			dnMap.put(Constants.DN_DATE_RECON_ACQ, dnEntity.getDateReconAcq());
			dnMap.put(Constants.DN_AMT_RECON_ACQ, dnEntity.getAmtReconAcq());
			dnMap.put(Constants.DN_O_AMT_RECON_ACQ, dnEntity.getoAmtReconAcq());
			dnMap.put(Constants.DN_ADL_RQST_AMT1, dnEntity.getAdlRqstAmt1());
			dnMap.put(Constants.DN_CUR_RECON_ACQ, dnEntity.getCurReconAcq());
			dnMap.put(Constants.DN_DATE_CNV_ACQ, dnEntity.getDateCnvAcq());
			dnMap.put(Constants.DN_CNV_RCN_ACQ_DE_POS, dnEntity.getCnvRcnAcqDePos());
			dnMap.put(Constants.DN_CNV_RCN_ACQ_RATE, dnEntity.getCnvRcnAcqRate());
			dnMap.put(Constants.DN_SYS_TRACE_AUDIT_NO, dnEntity.getSysTraceAuditNo());
			dnMap.put(Constants.DN_AMT_RECON_ISS, dnEntity.getAmtReconIss());
			dnMap.put(Constants.DN_AMT_RECON_NET, dnEntity.getAmtReconNet());
			dnMap.put(Constants.DN_AMT_CARD_BILL, dnEntity.getAmtCardBill());
			dnMap.put(Constants.DN_O_AMT_CARD_BILL, dnEntity.getoAmtCardBill());
			dnMap.put(Constants.DN_O_AMT_RECON_ISS, dnEntity.getoAmtReconIss());
			dnMap.put(Constants.DN_O_AMT_RECON_NET, dnEntity.getoAmtReconNet());
			dnMap.put(Constants.DN_ADL_RESP_AMT0, dnEntity.getAdlRespAmt0());
			dnMap.put(Constants.DN_CUR_RECON_ISS, dnEntity.getCurReconIss());
			dnMap.put(Constants.DN_CUR_RECON_NET, dnEntity.getCurReconNet());
			dnMap.put(Constants.DN_CUR_CARD_BILL, dnEntity.getCurCardBill());
			dnMap.put(Constants.DN_CNV_RCN_ISS_DE_POS, dnEntity.getCnvRcnIssDePos());
			dnMap.put(Constants.DN_CNV_RCN_ISS_RATE, dnEntity.getCnvRcnIssRate());
			dnMap.put(Constants.DN_DATE_CNV_ISS, dnEntity.getDateCnvIss());
			dnMap.put(Constants.DN_TRAN_TYPE_ID, dnEntity.getTranTypeId());
			dnMap.put(Constants.DN_AMT_TRAN, dnEntity.getAmtTran());
			dnMap.put(Constants.DN_O_AMT_TRAN, dnEntity.getoAmtTran());
			dnMap.put(Constants.DN_TSTAMP_LOCAL, dnEntity.getTstampLocal());
			dnMap.put(Constants.DN_MERCH_TYPE, dnEntity.getMerchType());
			dnMap.put(Constants.DN_CARD_ACPT_BUS_CODE, dnEntity.getCardAcptBusCode());
			dnMap.put(Constants.DN_CARD_ACPT_ID, dnEntity.getCardAcptId());
			dnMap.put(Constants.DN_RPT_LVL_ID_B, dnEntity.getRptLvlIdB());
			dnMap.put(Constants.DN_CUR_TRAN, dnEntity.getCurTran());
			dnMap.put(Constants.DN_MSG_RESON_CODE_ISS, dnEntity.getMsgResonCodeIss());
			dnMap.put(Constants.DN_MSG_RESON_CODE_ACQ, dnEntity.getMsgResonCodeAcq());
			dnMap.put(Constants.DN_TRAN_DESC, dnEntity.getTranDesc());

			dnMap.put(Constants.DN_ODE_MTI, dnEntity.getOdeMti());
			dnMap.put(Constants.DN_ODE_SYS_TRA_AUD_NO, dnEntity.getOdeSysTraAudNo());
			dnMap.put(Constants.DN_ODE_TSTAMP_LOCL_TR, dnEntity.getOdeTstampLoclTr());
			dnMap.put(Constants.DN_ODE_INST_ID_ACQ, dnEntity.getOdeInstIdAcq());
			dnMap.put(Constants.DN_DATE_RECON_ISS, dnEntity.getDateReconIss());
			dnMap.put(Constants.DN_DATE_RECON_NET, dnEntity.getDateReconNet());
			dnMap.put(Constants.DN_INST_ID_RECON_ISS, dnEntity.getInstIdReconIss());
			dnMap.put(Constants.DN_INST_ID_RECN_ISS_B, dnEntity.getInstIdRecnIssB());
			dnMap.put(Constants.DN_GMT_TIME, dnEntity.getGmtTime());
			dnMap.put(Constants.DN_INST_ID_ACQ, dnEntity.getInstIdAcq());
			dnMap.put(Constants.DN_EXT_RSP_CODE, dnEntity.getExtRspCode());
			dnMap.put(Constants.DN_ACT_CODE, dnEntity.getActCode());
			dnMap.put(Constants.DN_CARD_ACPT_NAME_LOC, dnEntity.getCardAcptNameLoc());
			dnMap.put(Constants.DN_CARD_ACPT_REGION, dnEntity.getCardAcptRegion());
			dnMap.put(Constants.DN_CARD_ACPT_COUNTRY, dnEntity.getCardAcptCountry());
			dnMap.put(Constants.DN_INST_ID_ISS, dnEntity.getInstIdIss());
			dnMap.put(Constants.DN_CVV_CVC_RESULT, dnEntity.getCvvCvcResult());
			dnMap.put(Constants.DN_CAVV_RESULT, dnEntity.getCavvResult());

			dnMap.put(Constants.DN_CARD_ACPT_TERM_ID, dnEntity.getCardAcptTermId());
			dnMap.put(Constants.DN_NET_TERM_ID, dnEntity.getNetTermId());
			dnMap.put(Constants.DN_POS_CRD_DAT_IN_CAP, dnEntity.getPosCrdDatInCap());
			dnMap.put(Constants.DN_POS_CRDHLDR_AUTH_C, dnEntity.getPosCrdhldrAuthC());
			dnMap.put(Constants.DN_POS_CARD_CAPT_CAP, dnEntity.getPosCardCaptCap());
			dnMap.put(Constants.DN_POS_OPER_ENV, dnEntity.getPosOperEnv());
			dnMap.put(Constants.DN_POS_CRDHLDR_PRESNT, dnEntity.getPosCrdhldrPresnt());
			dnMap.put(Constants.DN_POS_CARD_PRES, dnEntity.getPosCardPres());
			dnMap.put(Constants.DN_POS_CRD_DAT_IN_MOD, dnEntity.getPosCrdDatInMod());
			dnMap.put(Constants.DN_POS_CRDHLDR_A_METH, dnEntity.getPosCrdhldrAMeth());
			dnMap.put(Constants.DN_POS_CRDHLDR_AUTH, dnEntity.getPosCrdhldrAuth());
			dnMap.put(Constants.DN_POS_CRD_DAT_OT_CAP, dnEntity.getPosCrdDatOtCap());
			dnMap.put(Constants.DN_POS_TERM_OUT_CAP, dnEntity.getPosTermOutCap());
			dnMap.put(Constants.DN_POS_PIN_CAPT_CAP, dnEntity.getPosPinCaptCap());
			dnMap.put(Constants.DN_POS_TERM_OPTR, dnEntity.getPosTermOptr());
			dnMap.put(Constants.DN_TERM_CLASS, dnEntity.getTermClass());
			dnMap.put(Constants.DN_FIN_L_TSTAMP_TRANS, dnEntity.getFinLTstampTrans());
			dnMap.put(Constants.DN_FIN_RECORD_TSTAMP_TRANS, dnEntity.getFinRecordTstampTrans());
			dnMap.put(Constants.DN_MCI_UCAF_DATA, dnEntity.getMciUcafData());
			dnMap.put(Constants.DN_ADL_RQST_AMT0, dnEntity.getAdlRqstAmt0());
			dnMap.put(Constants.DN_ADL_DATA_PRIV_ISS, dnEntity.getAdlDataPrivIss());
			dnMap.put(Constants.DN_PROC_ID_ISS, dnEntity.getProcIdIss());

			for (int x = 0; x < Constants.dnHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));

				String value = (String) dnMap.get(Constants.dnHeaders.get(x));
				value = value != null ? value.trim() : value;
				if (isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					cell.setCellValue(Long.valueOf(value));
				}

			}
		}

	}

	private void createValidationSheet(Workbook workbook, List<ValidationEntity> validationEntities,
			Map<StyleKey, CellStyle> stylesMap) {
		Sheet sheet = workbook.createSheet("validation");

		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.validationHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.validationHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= validationEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			ValidationEntity validationEntity = validationEntities.get(j - 1);

			Map<String, Object> validationMap = new HashMap<String, Object>();

			validationMap.put(Constants.V_TRAN_NR, validationEntity.getTranNr());
			validationMap.put(Constants.V_MSG_TYPE_1, validationEntity.isMsgType1());
			validationMap.put(Constants.V_DRAFT_CAPTURE_2, validationEntity.isDraftCapture2());
			validationMap.put(Constants.V_STAND_IN_3, validationEntity.isStandin3());
			validationMap.put(Constants.V_SRCNODE_DATE_SETTLE_4, validationEntity.isSrcnodeDateSettle4());
			validationMap.put(Constants.V_SRCNODE_AMOUNT_REQUESTED_5, validationEntity.isSrcnodeAmountRequested5());
			validationMap.put(Constants.V_SRCNODE_CASH_REQUESTED_8, validationEntity.isSrcnodeCashRequested8());

			validationMap.put(Constants.V_SRCNODE_CURRENCY_CODE_11, validationEntity.isSrcnodeCurrencyCode11());
			validationMap.put(Constants.V_SRCNODE_CONVERSION_RATE_12, validationEntity.isSrcnodeConversionRate12());
			validationMap.put(Constants.V_SRCNODE_DATE_CONVERSION_13, validationEntity.isSrcnodeDateConversion13());
			validationMap.put(Constants.V_SRCNODE_ORIGINAL_DATA_14, validationEntity.isSrcnodeOriginalData14());
			validationMap.put(Constants.V_SNKNODE_REQ_SYS_TRACE_15, validationEntity.isSnknodeReqSysTrace15());
			validationMap.put(Constants.V_SNKNODE_REV_SYS_TRACE_16, validationEntity.isSnknodeRevSysTrace16());
			validationMap.put(Constants.V_SNKNODE_ADV_SYS_TRACE_17, validationEntity.isSnknodeAdvSysTrace17());
			validationMap.put(Constants.V_SNKNODE_DATE_SETTLE_18, validationEntity.isSnknodeDateSettle18());
			validationMap.put(Constants.V_SNKNODE_AMOUNT_REQUESTED_19, validationEntity.isSnknodeAmountRequested19());

			validationMap.put(Constants.V_SNKNODE_CASH_REQUESTED_22, validationEntity.isSnknodeCashRequested22());
			validationMap.put(Constants.V_SNKNODE_CURRENCY_CODE_25, validationEntity.isSnknodeCurrencyCode25());
			validationMap.put(Constants.V_SNKNODE_CONVERSION_RATE_26, validationEntity.isSnknodeConversionRate26());
			validationMap.put(Constants.V_SNKNODE_DATE_CONVERSION_27, validationEntity.isSnknodeDateConversion27());
			validationMap.put(Constants.V_TOTALS_GROUP_29, validationEntity.isTotalsGroup29());
			validationMap.put(Constants.V_TRAN_TYPE_30, validationEntity.isTranType30());

			validationMap.put(Constants.V_FROM_ACCOUNT_31, validationEntity.isFromAccount31());
			validationMap.put(Constants.V_TO_ACCOUNT_32, validationEntity.isToAccount32());
			validationMap.put(Constants.V_AMOUNT_TRAN_REQUESTED_33, validationEntity.isAmountTranRequested33());
			validationMap.put(Constants.V_AMOUNT_CASH_REQUESTED_36, validationEntity.isAmountCashRequested36());
			validationMap.put(Constants.V_GMT_DATE_TIME_39, validationEntity.isGmtDateTime39());
			validationMap.put(Constants.V_TIME_LOCAL_40, validationEntity.isTimeLocal40());

			validationMap.put(Constants.V_DATE_LOCAL_41, validationEntity.isDateLocal41());
			validationMap.put(Constants.V_MERCHANT_TYPE_43, validationEntity.isMerchantType43());
			validationMap.put(Constants.V_ACQUIRING_INST_44, validationEntity.isAcquiringInst44());
			validationMap.put(Constants.V_RSP_CODE_REQ_RSP_47, validationEntity.isRspCodeReqRsp47());
			validationMap.put(Constants.V_CARD_ACCEPTOR_TERM_ID_50, validationEntity.isCardAcceptorTermId50());

			validationMap.put(Constants.V_CARD_ACCEPTOR_ID_CODE_51, validationEntity.isCardAcceptorIdCode51());
			validationMap.put(Constants.V_CARD_ACCEPTOR_NAME_LOC_52, validationEntity.isCardAcceptorNameLoc52());
			validationMap.put(Constants.V_CURRENCY_CODE_TRAN_54, validationEntity.isCurrencyCodeTran54());
			validationMap.put(Constants.V_POS_DATA_CODE_58, validationEntity.isPosDataCode58());
			validationMap.put(Constants.V_MSG_REASON_CODE_REQ_IN_60, validationEntity.isMsgReasonCodeReqIn60());

			validationMap.put(Constants.V_MSG_REASON_CODE_REQ_OUT_61, validationEntity.isMsgReasonCodeReqOut61());
			validationMap.put(Constants.V_MSG_REASON_CODE_REV_62, validationEntity.isMsgReasonCodeRev62());
			validationMap.put(Constants.V_MSG_REASON_CODE_ADV_63, validationEntity.isMsgReasonCodeAdv63());
			validationMap.put(Constants.V_ADDR_VERIFICATION_RESULT_65, validationEntity.isAddrVerificationResult65());
			validationMap.put(Constants.V_ABORT_REASON_67, validationEntity.isAbortReason67());
			validationMap.put(Constants.V_ABORT_RSP_CODE_69, validationEntity.isAbortRspCode69());
			validationMap.put(Constants.V_IN_REQ_70, validationEntity.isInReq70());

			validationMap.put(Constants.V_IN_ADV_72, validationEntity.isInAdv72());
			validationMap.put(Constants.V_IN_REV_74, validationEntity.isInRev74());

			validationMap.put(Constants.V_SNKNODE_ACQUIRING_INST_87, validationEntity.isSnknodeAcquiringInst87());

			validationMap.put(Constants.V_CARD_VERIFICATION_RESULT_91, validationEntity.isCardVerificationResult91());
			validationMap.put(Constants.V_SECURE_3D_RESULT_92, validationEntity.isSecure3dResult92());
			validationMap.put(Constants.V_UCAF_DATA_98, validationEntity.isUcafData98());

			for (int x = 1; x < Constants.rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);

				if (x == 1) {
					cell.setCellStyle(stylesMap.get(StyleKey.COMMON));

					cell.setCellValue(Integer.valueOf((String) validationMap.get(Constants.validationHeaders.get(x))));
				} else {
					boolean flag = false;
					if (validationMap.get(Constants.validationHeaders.get(x)) instanceof Boolean) {
						flag = (Boolean) validationMap.get(Constants.validationHeaders.get(x));
					}
					// boolean flag = (boolean)
					// validationMap.get(Constants.validationHeaders.get(x));
					cell.setCellValue(flag ? "Passed" : "Failed");
					if (flag) {
						cell.setCellStyle(stylesMap.get(StyleKey.GREENCELL));
					} else {
						cell.setCellStyle(stylesMap.get(StyleKey.ORANGECELL));
					}
				}
			}
		}
	}

	private Map<StyleKey, CellStyle> getStyles(Workbook workbook) {

		Map<StyleKey, CellStyle> stylesMap = new HashMap<StyleKey, CellStyle>();

		CellStyle alignCenterStyle = workbook.createCellStyle();
		alignCenterStyle.setAlignment(HorizontalAlignment.CENTER);
		alignCenterStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		stylesMap.put(StyleKey.COMMON, alignCenterStyle);

		/* HEADER STYLE */
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		CellStyle headerSellStyle = workbook.createCellStyle();
		headerSellStyle.cloneStyleFrom(alignCenterStyle);
		headerSellStyle.setFont(boldFont);
		stylesMap.put(StyleKey.HEADER, headerSellStyle);

		/* GREEN CELL STYLE */
		CellStyle greenCellStyle = workbook.createCellStyle();
		greenCellStyle.cloneStyleFrom(alignCenterStyle);
		greenCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylesMap.put(StyleKey.GREENCELL, greenCellStyle);

		/* ORANGE CELL STYLE */
		CellStyle orangeCellStyle = workbook.createCellStyle();
		orangeCellStyle.cloneStyleFrom(alignCenterStyle);
		orangeCellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		orangeCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylesMap.put(StyleKey.ORANGECELL, orangeCellStyle);

		return stylesMap;

	}

	private boolean isNotNumeric(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}
}
