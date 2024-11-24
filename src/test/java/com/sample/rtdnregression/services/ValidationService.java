package com.sample.rtdnregression.services;

import java.util.ArrayList;
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
	private ExcelService excelService;

	public void validation() {
		List<RTEntity> rtEntities = rtService.getRTData();
		List<DNEntity> dnEntities = dnService.getDNData();
		List<ValidationEntity> validationEntities = new ArrayList<ValidationEntity>();

		Map<String, DNEntity> dnMap = new HashMap<>();
		for (DNEntity dn : dnEntities) {
			dnMap.put(dn.getTransactionId(), dn);
		}

		for (RTEntity rt : rtEntities) {
			DNEntity dn = dnMap.get(rt.getTransactionId());
			ValidationEntity validationEntity = new ValidationEntity();

			validationEntity.setTransactionId(rt.getTransactionId());

			validationEntity.setMsgType(validateMsgType(dn, rt));
			validationEntity.setDraftCapture(validateDraftCapture(dn, rt));
			validationEntity.setStandin(validateStandin(dn, rt));
			validationEntity.setSrcnodeDateSettle(validateSrcnodeDateSettle(dn, rt));
			validationEntity.setSrcnodeAmountRequested(validateSrcnodeAmountRequested(dn, rt));
			validationEntity.setSrcnodeCashRequested(validateSrcnodeCashRequested(dn, rt));
			validationEntity.setSrcnodeCurrencyCode(validateSrcnodeCurrencyCode(dn, rt));
			validationEntity.setSrcnodeDateConversion(validateSrcnodeDateConversion(dn, rt));
			validationEntity.setSrcnodeConversionRate(validateSrcnodeConversionRate(dn, rt));
			

			validationEntities.add(validationEntity);
		}

		excelService.createExcel(rtEntities, dnEntities, validationEntities);

	}

	private boolean validateMsgType(DNEntity dn, RTEntity rt) {
		int msgType = Integer.valueOf(rt.getMsgType());
		String hex = Integer.toHexString(msgType).toUpperCase();
		String calculatedMti = Integer.toHexString(Integer.parseInt(hex, 16) + Integer.parseInt("1010", 16))
				.toUpperCase();
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
		return rt.getSrcnodeDateSettle().substring(4).equals(dn.getDateReconAcq());
	}
	
	private boolean validateSrcnodeAmountRequested(DNEntity dn, RTEntity rt) {
		if(dn.getMti().equals("1430")) {
			return rt.getSrcnodeAmountRequested().equals(dn.getAmtReconAcq()) && rt.getSrcnodeAmountRequested().equals(dn.getoAmtReconAcq());
		} else {
			return rt.getSrcnodeAmountRequested().equals(dn.getAmtReconAcq());
		}
	}
	
	private boolean validateSrcnodeCashRequested(DNEntity dn, RTEntity rt) {
		return rt.getSrcnodeCashRequested().equals(dn.getAdlRqstAmt1());
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

}
