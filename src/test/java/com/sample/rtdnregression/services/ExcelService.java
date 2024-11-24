package com.sample.rtdnregression.services;

import java.io.FileOutputStream;
import java.util.Arrays;
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

import com.sample.rtdnregression.entities.DNEntity;
import com.sample.rtdnregression.entities.RTEntity;
import com.sample.rtdnregression.entities.ValidationEntity;
import com.sample.rtdnregression.models.StyleKey;

@Service
public class ExcelService {

	private final List<String> rtHeaders = Arrays.asList("trans_id", "msg_type", "draft_capture", "stand_in",
			"srcnode_date_settle", "srcnode_amount_requested", "srcnode_cash_requested", "srcnode_currency_code",
			"srcnode_date_conversion", "srcnode_conversion_rate");
	private final List<String> dnHeaders = Arrays.asList("trans_id", "mti", "func_code", "draft_capture_flg",
			"standin_act", "date_recon_acq", "amt_recon_acq", "o_amt_recon_acq", "adl_rqst_amt1", "cur_recon_acq",
			"date_cnv_acq", "cnv_rcn_acq_de_pos", "cnv_rcn_acq_rate");

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

		for (int i = 0; i < rtHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(rtHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= rtEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			RTEntity rtEntity = rtEntities.get(j - 1);

			Map<String, Object> rtMap = new HashMap<String, Object>();
			rtMap.put("trans_id", rtEntity.getTransactionId());
			rtMap.put("msg_type", rtEntity.getMsgType());
			rtMap.put("draft_capture", rtEntity.getDraftCapture());
			rtMap.put("stand_in", rtEntity.getStandIn());
			rtMap.put("srcnode_date_settle", rtEntity.getSrcnodeDateSettle());
			rtMap.put("srcnode_amount_requested", rtEntity.getSrcnodeAmountRequested());
			rtMap.put("srcnode_cash_requested", rtEntity.getSrcnodeCashRequested());
			rtMap.put("srcnode_currency_code", rtEntity.getSrcnodeCurrencyCode());
			rtMap.put("srcnode_date_conversion", rtEntity.getSrcnodeDateConversion());
			rtMap.put("srcnode_conversion_rate", rtEntity.getSrcnodeConversionRate());

			for (int x = 0; x < rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				
				String value = (String) rtMap.get(rtHeaders.get(x));
				if(isNotNumeric(value) || (value.length() > 1 && value.startsWith("0"))) {
					cell.setCellValue(value);
				} else {
					cell.setCellValue(Integer.valueOf(value));
				}
			}

		}

	}

	private void createDNSheet(Workbook workbook, List<DNEntity> dnEntities, Map<StyleKey, CellStyle> stylesMap) {

		Sheet sheet = workbook.createSheet("dn");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < dnHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(dnHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= dnEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			DNEntity dnEntity = dnEntities.get(j - 1);

			Map<String, Object> dnMap = new HashMap<String, Object>();
			dnMap.put("trans_id", dnEntity.getTransactionId());
			dnMap.put("mti", dnEntity.getMti());
			dnMap.put("func_code", dnEntity.getFuncCode());
			dnMap.put("draft_capture_flg", dnEntity.getDraftCaptureFlg());
			dnMap.put("standin_act", dnEntity.getStandinAct());
			dnMap.put("date_recon_acq", dnEntity.getDateReconAcq());
			dnMap.put("amt_recon_acq", dnEntity.getAmtReconAcq());
			dnMap.put("o_amt_recon_acq", dnEntity.getoAmtReconAcq());
			dnMap.put("adl_rqst_amt1", dnEntity.getAdlRqstAmt1());
			dnMap.put("cur_recon_acq", dnEntity.getCurReconAcq());
			dnMap.put("date_cnv_acq", dnEntity.getDateCnvAcq());
			dnMap.put("cnv_rcn_acq_de_pos", dnEntity.getCnvRcnAcqDePos());
			dnMap.put("cnv_rcn_acq_rate", dnEntity.getCnvRcnAcqRate());

			for (int x = 0; x < dnHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);
				cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
				
				String value = (String)dnMap.get(dnHeaders.get(x));
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

		for (int i = 0; i < rtHeaders.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(rtHeaders.get(i));
			cell.setCellStyle(stylesMap.get(StyleKey.HEADER));
		}

		for (int j = 1; j <= validationEntities.size(); j++) {
			Row dataRow = sheet.createRow(j);

			ValidationEntity validationEntity = validationEntities.get(j - 1);

			Map<String, Object> validationMap = new HashMap<String, Object>();
			validationMap.put("trans_id", validationEntity.getTransactionId());
			validationMap.put("msg_type", validationEntity.isMsgType());
			validationMap.put("draft_capture", validationEntity.isDraftCapture());
			validationMap.put("stand_in", validationEntity.isStandin());
			validationMap.put("srcnode_date_settle", validationEntity.isSrcnodeDateSettle());
			validationMap.put("srcnode_amount_requested", validationEntity.isSrcnodeAmountRequested());
			validationMap.put("srcnode_cash_requested", validationEntity.isSrcnodeCashRequested());
			validationMap.put("srcnode_currency_code", validationEntity.isSrcnodeCurrencyCode());
			validationMap.put("srcnode_date_conversion", validationEntity.isSrcnodeDateConversion());
			validationMap.put("srcnode_conversion_rate", validationEntity.isSrcnodeConversionRate());

			for (int x = 0; x < rtHeaders.size(); x++) {
				Cell cell = dataRow.createCell(x);

				if (x == 0) {
					cell.setCellStyle(stylesMap.get(StyleKey.COMMON));
					cell.setCellValue(Integer.valueOf((String) validationMap.get(rtHeaders.get(x))));
				} else {
					boolean flag = (boolean) validationMap.get(rtHeaders.get(x));
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
