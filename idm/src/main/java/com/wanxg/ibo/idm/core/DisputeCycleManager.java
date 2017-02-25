package com.wanxg.ibo.idm.core;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.wanxg.ibo.idm.disputecycle.DisputeFolder;
import com.wanxg.ibo.idm.disputecycle.DisputeReason;
import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;

@Stateless
public class DisputeCycleManager {

	@Inject
	private TransactionProcessingService itp;

	@Inject
	private DisputeFolderManager disputeFolderManager;

	public DisputeFolder disputeTransaction(Long transactionId) {
		
		DisputeFolder disputeFolder = null;
		

		ExtTransaction extTrn = itp.findTransaction(transactionId);

		if (extTrn != null) {

			DisputeFolder df = TransactionMapper.mapToDisputeFolder(extTrn);

			df.setName("MANUAL DISPUTE");

			df.setDisputeReason(DisputeReason.CARDHOLDER_DISPUTE);

			disputeFolderManager.createDisputeFolder(df);
			
			return df;
		}
		
		else
			
			System.out.println("Transaction not found for id: " + transactionId);
		
		return disputeFolder;
	}

}
