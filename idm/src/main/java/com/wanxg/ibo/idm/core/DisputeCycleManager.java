package com.wanxg.ibo.idm.core;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.wanxg.ibo.idm.disputecycle.DisputeFolder;
import com.wanxg.ibo.idm.disputecycle.DisputeReason;
import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.ServiceException;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;

@Stateless
public class DisputeCycleManager {

	@Inject
	private TransactionProcessingService itp;

	@Inject
	private DisputeFolderManager disputeFolderManager;

	public DisputeFolder disputeTransaction(Long transactionId) {
		
		DisputeFolder disputeFolder = null;
		

		ExtTransaction extTrn = null;
		try {
			extTrn = itp.findTransaction(transactionId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (extTrn != null) {

			DisputeFolder df = TransactionMapper.mapToDisputeFolder(extTrn);

			df.setName("MANUAL DISPUTE");

			df.setDisputeReason(DisputeReason.CARDHOLDER_DISPUTE);

			disputeFolderManager.createDisputeFolder(df);
			
			return df;
		}
		
		return disputeFolder;
	}

}
