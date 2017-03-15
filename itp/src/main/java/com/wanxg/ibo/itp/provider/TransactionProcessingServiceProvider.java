package com.wanxg.ibo.itp.provider;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.ServiceException;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;
import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.exception.BusinessException;
import com.wanxg.ibo.itp.transaction.Transaction;

@Stateless
@WebService(serviceName = "TransactionProcessingService",endpointInterface = "com.wanxg.ibo.itp.contract.TransactionProcessingService")
public class TransactionProcessingServiceProvider implements TransactionProcessingService {

	@Inject
	TransactionManager tm;

	public List<ExtTransaction> findTransactionList() throws ServiceException {
		
		List<Transaction> list;
		try {
			list = tm.findTransaction();
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		return TransactionMapper.mapToExtTransactionList(list);
	}

	public ExtTransaction findTransaction(Long id) throws ServiceException {

		Transaction transaction;
		try {
			transaction = tm.findTransaction(id);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		
		return TransactionMapper.mapToExtTransaction(transaction);
	}

}
