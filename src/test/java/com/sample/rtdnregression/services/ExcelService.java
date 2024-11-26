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
import com.sample.rtdnregression.models.StyleKey;

@Service
public class ExcelService {

	public void createExcel(List<RTEntity> rtEntities, List<DNEntity> dnEntities,
			List<ValidationEntity> validationEntities) {
		String fileName = "result.xlsx";

		try (Workbook workbook = new XSSFWorkbook()) {
			Map<StyleKey, CellStyle> stylesMap = getStyles(workbook);
			createRTSheet(workbook, rtEntities, stylesMap);
			createDNSheet(workbook, dnEntities, stylesMap);
			createValidationSheet(workbook, validationEntities, stylesMap);

			try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
				workbook.write(fileOut);
			}
		} catch (Exception e) {
			e.printStackTrace();
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

			for (int x = 0; x < Constants.rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				
				String value = (String) rtMap.get(Constants.rtHeaders.get(x));
				if(isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					cell.setCellValue(Integer.valueOf(value));
				}
			}
			
			System.out.println("Created RT Sheet");

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
			dnMap.put(Constants.DN_SYS_AUDIT_TRACE, dnEntity.getSysAuditTrace());
			
			for (int x = 0; x < Constants.dnHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				
				String value = (String)dnMap.get(Constants.dnHeaders.get(x));
				if(isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					cell.setCellValue(Integer.valueOf(value));
				}
				
			}
		}

	}

	private void createValidationSheet(Workbook workbook, List<ValidationEntity> validationEntities,
			Map<StyleKey, CellStyle> stylesMap) {
		Sheet sheet = workbook.createSheet("validation");

		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < Constants.rtHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(Constants.rtHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= validationEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			ValidationEntity validationEntity = validationEntities.get(j - 1);

			Map<String, Object> validationMap = new HashMap<String, Object>();
			
			validationMap.put(Constants.RT_TRAN_NR, validationEntity.getTranNr());
			validationMap.put(Constants.RT_MSG_TYPE, validationEntity.isMsgType());
			validationMap.put(Constants.RT_DRAFT_CAPTURE, validationEntity.isDraftCapture());
			validationMap.put(Constants.RT_STAND_IN, validationEntity.isStandin());
			validationMap.put(Constants.RT_SRCNODE_DATE_SETTLE, validationEntity.isSrcnodeDateSettle());
			validationMap.put(Constants.RT_SRCNODE_AMOUNT_REQUESTED, validationEntity.isSrcnodeAmountRequested());
			validationMap.put(Constants.RT_SRCNODE_CASH_REQUESTED, validationEntity.isSrcnodeCashRequested());
			validationMap.put(Constants.RT_SRCNODE_CURRENCY_CODE, validationEntity.isSrcnodeCurrencyCode());
			validationMap.put(Constants.RT_SRCNODE_DATE_CONVERSION, validationEntity.isSrcnodeDateConversion());
			validationMap.put(Constants.RT_SRCNODE_CONVERSION_RATE, validationEntity.isSrcnodeConversionRate());
			validationMap.put(Constants.RT_SNKNODE_REQ_SYS_TRACE, validationEntity.isSnknodeReqSysTrace());
			validationMap.put(Constants.RT_SNKNODE_REV_SYS_TRACE, validationEntity.isSnknodeRevSysTrace());
			validationMap.put(Constants.RT_SNKNODE_ADV_SYS_TRACE, validationEntity.isSnknodeAdvSysTrace());

			for (int x = 0; x < Constants.rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);

				if (x == 0) {
					cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
					cell.setCellValue(Integer.valueOf((String) validationMap.get(Constants.rtHeaders.get(x))));
				} else {
					boolean flag = (boolean) validationMap.get(Constants.rtHeaders.get(x));
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
