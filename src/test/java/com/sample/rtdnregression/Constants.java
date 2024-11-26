package com.sample.rtdnregression;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String DN_TRAN_NUMBER = "TRAN_NUMBER";
	public static final String DN_MTI = "MTI";
	public static final String DN_FUNC_CODE = "FUNC_CODE";
	public static final String DN_DRAFT_CAPTURE_FLG = "DRAFT_CAPTURE_FLG";
	public static final String DN_STANDIN_ACT = "STANDIN_ACT";
	public static final String DN_DATE_RECON_ACQ = "DATE_RECON_ACQ";
	public static final String DN_AMT_RECON_ACQ = "AMT_RECON_ACQ";
	public static final String DN_O_AMT_RECON_ACQ = "O_AMT_RECON_ACQ";
	public static final String DN_ADL_RQST_AMT1 = "ADL_RQST_AMT1";
	public static final String DN_CUR_RECON_ACQ = "CUR_RECON_ACQ";
	public static final String DN_DATE_CNV_ACQ = "DATE_CNV_ACQ";
	public static final String DN_CNV_RCN_ACQ_DE_POS = "CNV_RCN_ACQ_DE_POS";
	public static final String DN_CNV_RCN_ACQ_RATE = "CNV_RCN_ACQ_RATE";
	public static final String DN_SYS_AUDIT_TRACE = "SYS_AUDIT_TRACE";
	public static final String DN_AMT_RECON_ISS = "AMT_RECON_ISS";
	public static final String DN_AMT_RECON_NET = "AMT_RECON_NET";
	public static final String DN_AMT_CARD_BILL = "AMT_CARD_BILL";
	public static final String DN_O_AMT_CARD_BILL = "O_AMT_CARD_BILL";
	public static final String DN_O_AMT_RECON_ISS = "O_AMT_RECON_ISS";
	public static final String DN_O_AMT_RECON_NET = "O_AMT_RECON_NET";

	public static final String RT_NAME = "rtname";
	public static final String RT_TRAN_NR = "tran_nr";
	public static final String RT_MSG_TYPE = "msg_type";
	public static final String RT_DRAFT_CAPTURE = "draft_capture";
	public static final String RT_STAND_IN = "stand_in";
	public static final String RT_SRCNODE_DATE_SETTLE = "srcnode_date_settle";
	public static final String RT_SRCNODE_AMOUNT_REQUESTED = "srcnode_amount_requested";
	public static final String RT_SRCNODE_CASH_REQUESTED = "srcnode_cash_requested";
	public static final String RT_SRCNODE_CURRENCY_CODE = "srcnode_currency_code";
	public static final String RT_SRCNODE_DATE_CONVERSION = "srcnode_date_conversion";
	public static final String RT_SRCNODE_CONVERSION_RATE = "srcnode_conversion_rate";
	public static final String RT_SNKNODE_REQ_SYS_TRACE = "snknode_req_sys_trace";
	public static final String RT_SNKNODE_REV_SYS_TRACE = "snknode_rev_sys_trace";
	public static final String RT_SNKNODE_ADV_SYS_TRACE = "snknode_adv_sys_trace";
	public static final String RT_SNKNODE_AMOUNT_REQUESTED = "snknode_amount_requested";

	public static final List<String> rtHeaders = Arrays.asList(RT_NAME, RT_TRAN_NR, RT_MSG_TYPE, RT_DRAFT_CAPTURE, RT_STAND_IN,
			RT_SRCNODE_DATE_SETTLE, RT_SRCNODE_AMOUNT_REQUESTED, RT_SRCNODE_CASH_REQUESTED, RT_SRCNODE_CURRENCY_CODE,
			RT_SRCNODE_DATE_CONVERSION, RT_SRCNODE_CONVERSION_RATE, RT_SNKNODE_REQ_SYS_TRACE, RT_SNKNODE_REV_SYS_TRACE,
			RT_SNKNODE_ADV_SYS_TRACE, RT_SNKNODE_AMOUNT_REQUESTED);
	public static final List<String> dnHeaders = Arrays.asList(DN_TRAN_NUMBER, DN_MTI, DN_FUNC_CODE,
			DN_DRAFT_CAPTURE_FLG, DN_STANDIN_ACT, DN_DATE_RECON_ACQ, DN_AMT_RECON_ACQ, DN_O_AMT_RECON_ACQ,
			DN_ADL_RQST_AMT1, DN_CUR_RECON_ACQ, DN_DATE_CNV_ACQ, DN_CNV_RCN_ACQ_DE_POS, DN_CNV_RCN_ACQ_RATE,
			DN_SYS_AUDIT_TRACE, DN_AMT_RECON_ISS, DN_AMT_RECON_NET, DN_AMT_CARD_BILL, DN_O_AMT_CARD_BILL,
			DN_O_AMT_RECON_ISS, DN_O_AMT_RECON_NET);

}