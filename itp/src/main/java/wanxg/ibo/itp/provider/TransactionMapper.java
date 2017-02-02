package wanxg.ibo.itp.provider;

import java.util.*;
import wanxg.ibo.itp.contract.ExtTransaction;
import wanxg.ibo.itp.core.entities.Transaction;

public class TransactionMapper {
	
	public static ExtTransaction mapToExtTransaction(Transaction trn){
		
		ExtTransaction extTrn = new ExtTransaction();
		
		extTrn.setId(trn.getId());
		extTrn.setTransactionAmount(trn.getTransactionAmount());
		extTrn.setCurrency(trn.getCurrency());
		extTrn.setCardScheme(trn.getCardScheme());
		
		return extTrn;
	}

	public static List<ExtTransaction> mapToExtTransactionList(List<Transaction> list){
		
		
		List<ExtTransaction> extList = new ArrayList<ExtTransaction>();
		
		list.forEach(item->extList.add(mapToExtTransaction(item)));
		
		return extList;
	}
	
}
