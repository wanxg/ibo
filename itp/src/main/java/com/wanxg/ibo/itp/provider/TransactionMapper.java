package com.wanxg.ibo.itp.provider;

import java.util.*;

import com.wanxg.ibo.itp.contract.ExtAmount;
import com.wanxg.ibo.itp.contract.ExtCard;
import com.wanxg.ibo.itp.contract.ExtTerminalCategory;
import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.ExtTransactionStatus;
import com.wanxg.ibo.itp.contract.ExtTransactionType;
import com.wanxg.ibo.itp.transaction.Transaction;

public class TransactionMapper {
	
	public static ExtTransaction mapToExtTransaction(Transaction trn){
		
		if(trn==null) return null;
		
		ExtTransaction extTrn = new ExtTransaction();
		
		extTrn.setId(trn.getId());
		extTrn.setMessageTypeIdentifier(trn.getMessageTypeIdentifier());
		extTrn.setFunctionCode(trn.getFunctionCode());
		
		extTrn.setTransactionType( trn.getTransactionType()==null ? null : ExtTransactionType.valueOf(trn.getTransactionType().toString()));
		
		extTrn.setTransactionStatus( trn.getTransactionStatus() == null? null :  ExtTransactionStatus.valueOf(trn.getTransactionStatus().toString()));
		
		
		extTrn.setSuspendDescription(trn.getSuspendDescription());
		extTrn.setCardSchemeCode(trn.getCardSchemeCode());
		extTrn.setAcquiringBankCode(trn.getAcquiringBankCode());
		extTrn.setIssuingBankId(trn.getIssuingBankId());
		extTrn.setCardType(trn.getCardType());
		extTrn.setBrand(trn.getBrand());
		extTrn.setAcquiringReferenceData(trn.getAcquiringBankCode());
		extTrn.setTransactionLocalDateAndTime(trn.getTransactionLocalDateAndTime());
		
		extTrn.setTerminalCategory(trn.getTerminalCategory()==null? null : ExtTerminalCategory.valueOf(trn.getTerminalCategory().toString()) );
		
		
		if(trn.getTransactionAmount()!=null)
			extTrn.setTransactionAmount(new ExtAmount(trn.getTransactionAmount().getValue(),trn.getTransactionAmount().getExponent(),trn.getTransactionAmount().getIsoCode()));
		else
			extTrn.setTransactionAmount(null);
		
		if(trn.getReconciliationAmount()!=null)
			extTrn.setReconciliationAmount(new ExtAmount(trn.getReconciliationAmount().getValue(),trn.getReconciliationAmount().getExponent(),trn.getReconciliationAmount().getIsoCode()));
		else
			extTrn.setReconciliationAmount(null);
		
		extTrn.setExchangeRateDate(trn.getExchangeRateDate());
		extTrn.setRejectedFlag(trn.isRejectedFlag());
		extTrn.setReversalFlag(trn.isReversalFlag());
		extTrn.setProcessingDate(trn.getProcessingDate());
		extTrn.setProcessorId(trn.getProcessorId());
		extTrn.setTransmissionDateAndTime(trn.getTransmissionDateAndTime());
		extTrn.setReversedFlag(trn.isReversedFlag());
		
		if(extTrn.getCard()!=null)
			extTrn.setCard(new ExtCard(trn.getCard().getCardNumber(),   trn.getCard().getExpiryDate(), trn.getCard().getSequenceNumber()));
		
		else
			extTrn.setCard(null);
		
		extTrn.setMerchant(trn.getMerchant());
		extTrn.setExtractedStatus(trn.getExtractedStatus());
		extTrn.setExtractedTimestamp(trn.getExtractedTimestamp());
		extTrn.setCreditDebitIndicator(trn.getCreditDebitIndicator());
		extTrn.setPanToken(trn.getPanToken());
		
		return extTrn;
	}

	public static List<ExtTransaction> mapToExtTransactionList(List<Transaction> list){
		
		
		List<ExtTransaction> extList = new ArrayList<ExtTransaction>();
		
		list.forEach(item->extList.add(mapToExtTransaction(item)));
		
		return extList;
	}
	
}
