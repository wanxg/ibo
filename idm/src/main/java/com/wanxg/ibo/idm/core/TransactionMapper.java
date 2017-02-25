package com.wanxg.ibo.idm.core;

import com.wanxg.ibo.idm.disputecycle.DisputeFolder;
import com.wanxg.ibo.itp.contract.ExtTransaction;

public class TransactionMapper {
	
	public static DisputeFolder mapToDisputeFolder(ExtTransaction extTransaction){
		
		DisputeFolder df = new DisputeFolder();
		
		df.setCardSchemeCode(extTransaction.getCardSchemeCode());
		df.setTransactionIdentifier(extTransaction.getId());		
		
		return df;
		
	}

}
