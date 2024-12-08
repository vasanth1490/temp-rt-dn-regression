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
	public static final String DN_ADL_RQST_AMT_TYP1 = "ADL_RQST_AMT_TYP1";
	public static final String DN_CUR_RECON_ACQ = "CUR_RECON_ACQ";
	public static final String DN_DATE_CNV_ACQ = "DATE_CNV_ACQ";
	public static final String DN_CNV_RCN_ACQ_DE_POS = "CNV_RCN_ACQ_DE_POS";
	public static final String DN_CNV_RCN_ACQ_RATE = "CNV_RCN_ACQ_RATE";
	public static final String DN_SYS_TRACE_AUDIT_NO = "SYS_TRACE_AUDIT_NO";
	public static final String DN_AMT_RECON_ISS = "AMT_RECON_ISS";
	public static final String DN_AMT_RECON_NET = "AMT_RECON_NET";
	public static final String DN_AMT_CARD_BILL = "AMT_CARD_BILL";
	public static final String DN_O_AMT_CARD_BILL = "O_AMT_CARD_BILL";
	public static final String DN_O_AMT_RECON_ISS = "O_AMT_RECON_ISS";
	public static final String DN_O_AMT_RECON_NET = "O_AMT_RECON_NET";
	public static final String DN_ADL_RESP_AMT0 = "ADL_RESP_AMT0";
	public static final String DN_ADL_RQST_AMT_TYP0 = "ADL_RQST_AMT_TYP0";
	public static final String DN_CUR_RECON_ISS = "CUR_RECON_ISS";
	public static final String DN_CUR_RECON_NET = "CUR_RECON_NET";
	public static final String DN_CUR_CARD_BILL = "CUR_CARD_BILL";
	public static final String DN_CNV_RCN_ISS_DE_POS = "CNV_RCN_ISS_DE_POS";
	public static final String DN_CNV_RCN_ISS_RATE = "CNV_RCN_ISS_RATE";
	public static final String DN_DATE_CNV_ISS = "DATE_CNV_ISS";
	public static final String DN_TRAN_TYPE_ID = "TRAN_TYPE_ID";
	public static final String DN_AMT_TRAN = "AMT_TRAN";
	public static final String DN_O_AMT_TRAN = "O_AMT_TRAN";
	public static final String DN_TSTAMP_LOCAL = "TSTAMP_LOCAL";
	public static final String DN_MERCH_TYPE = "MERCH_TYPE";
	public static final String DN_CARD_ACPT_BUS_CODE = "CARD_ACPT_BUS_CODE";
	public static final String DN_CARD_ACPT_ID = "CARD_ACPT_ID";
	public static final String DN_RPT_LVL_ID_B = "RPT_LVL_ID_B";
	public static final String DN_CUR_TRAN = "CUR_TRAN";
	public static final String DN_MSG_RESON_CODE_ISS = "MSG_RESON_CODE_ISS";
	public static final String DN_MSG_RESON_CODE_ACQ = "MSG_RESON_CODE_ACQ";
	public static final String DN_TRAN_DESC = "TRAN_DESC";
	public static final String DN_ODE_MTI = "ODE_MTI";
	public static final String DN_ODE_SYS_TRA_AUD_NO = "ODE_SYS_TRA_AUD_NO";
	public static final String DN_ODE_TSTAMP_LOCL_TR = "ODE_TSTAMP_LOCL_TR";
	public static final String DN_ODE_INST_IS_ACQ = "ODE_INST_IS_ACQ";
	public static final String DN_DATE_RECON_ISS = "DATE_RECON_ISS";
	public static final String DN_DATE_RECON_NET = "DATE_RECON_NET";
	public static final String DN_INST_ID_RECON_ISS = "INST_ID_RECON_ISS";
	public static final String DN_INST_ID_RECN_ISS_B = "INST_ID_RECN_ISS_B";
	public static final String DN_GMT_TIME = "GMT_TIME";
	public static final String DN_INST_ID_ACQ = "INST_ID_ACQ";
	public static final String DN_EXT_RSP_CODE = "EXT_RSP_CODE";
	public static final String DN_ACT_CODE = "ACT_CODE";
	public static final String DN_CARD_ACPT_NAME_LOC = "CARD_ACPT_NAME_LOC";
	public static final String DN_CARD_ACPT_REGION = "CARD_ACPT_REGION";
	public static final String DN_CARD_ACPT_COUNTRY = "CARD_ACPT_COUNTRY";
	public static final String DN_INST_ID_ISS = "INST_ID_ISS";
	public static final String DN_CVV_CVC_RESULT = "CVV_CVC_RESULT";
	public static final String DN_CAVV_RESULT = "CAVV_RESULT";
	

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
	public static final String RT_SNKNODE_CASH_REQUESTED = "snknode_cash_requested";
	public static final String RT_SNKNODE_CURRENCY_CODE = "snknode_currency_code";
	public static final String RT_SNKNODE_CONVERSION_RATE = "snknode_conversion_rate";
	public static final String RT_SNKNODE_DATE_CONVERSION = "snknode_date_conversion";
	public static final String RT_TRAN_TYPE = "tran_type";
	public static final String RT_FROM_ACCOUNT = "from_account";
	public static final String RT_TO_ACCOUNT = "to_account";
	public static final String RT_AMOUNT_TRAN_REQUESTED = "amount_tran_requested";
	public static final String RT_TIME_LOCAL = "time_local";
	public static final String RT_DATE_LOCAL = "date_local";
	public static final String RT_MERCHANT_TYPE = "merchant_type";
	public static final String RT_CARD_ACCEPTOR_ID_CODE = "card_acceptor_id_code";
	public static final String RT_CURRENCY_CODE_TRAN = "currency_code_tran";
	public static final String RT_MSG_REASON_CODE_REQ_OUT = "msg_reason_code_req_out";
	public static final String RT_MSG_REASON_CODE_REV = "msg_reason_code_rev";
	public static final String RT_MSG_REASON_CODE_ADV = "msg_reason_code_adv";
	public static final String RT_ABORT_REASON = "abort_reason";
	public static final String RT_ABORT_RSP_CODE = "abort_rsp_code";
	public static final String RT_SRCNODE_ORIGINAL_DATA = "srcnode_original_data";
	public static final String RT_SNKNODE_DATE_SETTLE = "snknode_date_settle";
	public static final String RT_SNKNODE_BATCH_SETTLE_DATE = "SNKNODE_BATCH_SETTLE_DATE";
	public static final String RT_TOTALS_GROUP = "totals_group";
	public static final String RT_GMT_DATE_TIME = "gmt_date_time";
	public static final String RT_ACQUIRING_INST = "acquiring_inst";
	public static final String RT_RSP_CODE_REQ_RSP = "rsp_code_req_rsp";
	public static final String RT_CARD_ACCEPTOR_NAME_LOC = "card_acceptor_name_loc";
	public static final String RT_IN_REQ = "in_req";
	public static final String RT_IN_ADV = "in_adv";
	public static final String RT_IN_REV = "in_rev";
	public static final String RT_SNKNODE_ACQUIRING_INST = "snknode_acquiring_inst";
	public static final String RT_CARD_VERIFICATION_RESULT = "card_verification_result";
	public static final String RT_SECURE_3D_RESULT = "secure_3d_result";
	public static final String RT_MSG_REASON_CODE_REQ_IN = "msg_reason_code_req_in";

	public static final List<String> rtHeaders = Arrays.asList(RT_NAME, RT_TRAN_NR, RT_MSG_TYPE, RT_DRAFT_CAPTURE,
			RT_STAND_IN, RT_SRCNODE_DATE_SETTLE, RT_SRCNODE_AMOUNT_REQUESTED, RT_SRCNODE_CASH_REQUESTED,
			RT_SRCNODE_CURRENCY_CODE, RT_SRCNODE_DATE_CONVERSION, RT_SRCNODE_CONVERSION_RATE, RT_SNKNODE_REQ_SYS_TRACE,
			RT_SNKNODE_REV_SYS_TRACE, RT_SNKNODE_ADV_SYS_TRACE, RT_SNKNODE_AMOUNT_REQUESTED, RT_SNKNODE_CASH_REQUESTED,
			RT_SNKNODE_CURRENCY_CODE, RT_SNKNODE_CONVERSION_RATE, RT_SNKNODE_DATE_CONVERSION, RT_TRAN_TYPE,
			RT_FROM_ACCOUNT, RT_TO_ACCOUNT, RT_AMOUNT_TRAN_REQUESTED, RT_TIME_LOCAL, RT_DATE_LOCAL, RT_MERCHANT_TYPE,
			RT_CARD_ACCEPTOR_ID_CODE, RT_CURRENCY_CODE_TRAN, RT_MSG_REASON_CODE_REQ_OUT, RT_MSG_REASON_CODE_REV,
			RT_MSG_REASON_CODE_ADV, RT_ABORT_REASON, RT_ABORT_RSP_CODE, RT_SRCNODE_ORIGINAL_DATA,
			RT_SNKNODE_DATE_SETTLE, RT_SNKNODE_BATCH_SETTLE_DATE, RT_TOTALS_GROUP, RT_GMT_DATE_TIME, RT_ACQUIRING_INST,
			RT_RSP_CODE_REQ_RSP, RT_CARD_ACCEPTOR_NAME_LOC, RT_IN_REQ, RT_IN_ADV, RT_IN_REV, RT_SNKNODE_ACQUIRING_INST,
			RT_CARD_VERIFICATION_RESULT, RT_SECURE_3D_RESULT, RT_MSG_REASON_CODE_REQ_IN

	);
	public static final List<String> dnHeaders = Arrays.asList(DN_TRAN_NUMBER, DN_MTI, DN_FUNC_CODE,
			DN_DRAFT_CAPTURE_FLG, DN_STANDIN_ACT, DN_DATE_RECON_ACQ, DN_AMT_RECON_ACQ, DN_O_AMT_RECON_ACQ,
			DN_ADL_RQST_AMT1, DN_ADL_RQST_AMT_TYP1, DN_CUR_RECON_ACQ, DN_DATE_CNV_ACQ, DN_CNV_RCN_ACQ_DE_POS,
			DN_CNV_RCN_ACQ_RATE, DN_SYS_TRACE_AUDIT_NO, DN_AMT_RECON_ISS, DN_AMT_RECON_NET, DN_AMT_CARD_BILL,
			DN_O_AMT_CARD_BILL, DN_O_AMT_RECON_ISS, DN_O_AMT_RECON_NET, DN_ADL_RESP_AMT0, DN_ADL_RQST_AMT_TYP0,
			DN_CUR_RECON_ISS, DN_CUR_RECON_NET, DN_CUR_CARD_BILL, DN_CNV_RCN_ISS_DE_POS, DN_CNV_RCN_ISS_RATE,
			DN_DATE_CNV_ISS, DN_TRAN_TYPE_ID, DN_AMT_TRAN, DN_O_AMT_TRAN, DN_TSTAMP_LOCAL, DN_MERCH_TYPE,
			DN_CARD_ACPT_BUS_CODE, DN_CARD_ACPT_ID, DN_RPT_LVL_ID_B, DN_CUR_TRAN, DN_MSG_RESON_CODE_ISS,
			DN_MSG_RESON_CODE_ACQ, DN_TRAN_DESC, DN_ODE_MTI, DN_ODE_SYS_TRA_AUD_NO, DN_ODE_TSTAMP_LOCL_TR,
			DN_ODE_INST_IS_ACQ, DN_DATE_RECON_ISS, DN_DATE_RECON_NET, DN_INST_ID_RECON_ISS, DN_INST_ID_RECN_ISS_B,
			DN_GMT_TIME, DN_INST_ID_ACQ, DN_EXT_RSP_CODE, DN_ACT_CODE, DN_CARD_ACPT_NAME_LOC, DN_CARD_ACPT_REGION,
			DN_CARD_ACPT_COUNTRY, DN_INST_ID_ISS, DN_CVV_CVC_RESULT, DN_CAVV_RESULT

	);

}
