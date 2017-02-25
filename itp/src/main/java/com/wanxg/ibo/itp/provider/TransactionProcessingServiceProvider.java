package com.wanxg.ibo.itp.provider;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;
import com.wanxg.ibo.itp.core.TransactionManager;

@Stateless
@WebService(serviceName = "TransactionProcessingService",endpointInterface = "com.wanxg.ibo.itp.contract.TransactionProcessingService")
public class TransactionProcessingServiceProvider implements TransactionProcessingService {

	@Inject
	TransactionManager tm;

	public List<ExtTransaction> findTransactionList() {

		return TransactionMapper.mapToExtTransactionList(tm.findTransaction());
	}

	public ExtTransaction findTransaction(Long id) {

		return TransactionMapper.mapToExtTransaction(tm.findTransaction(id));
	}

}
