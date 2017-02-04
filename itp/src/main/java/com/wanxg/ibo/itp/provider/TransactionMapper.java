package com.wanxg.ibo.itp.provider;

import java.util.*;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.transaction.Transaction;

public class TransactionMapper {
	
	public static ExtTransaction mapToExtTransaction(Transaction trn){
		
		ExtTransaction extTrn = new ExtTransaction();
		
		extTrn.setId(trn.getId());
		extTrn.setBrand(trn.getBrand());
		extTrn.setCardSchemeCode(trn.getCardSchemeCode());
		extTrn.setProcessingDate(trn.getProcessingDate());
		
		return extTrn;
	}

	public static List<ExtTransaction> mapToExtTransactionList(List<Transaction> list){
		
		
		List<ExtTransaction> extList = new ArrayList<ExtTransaction>();
		
		list.forEach(item->extList.add(mapToExtTransaction(item)));
		
		return extList;
	}
	
}
