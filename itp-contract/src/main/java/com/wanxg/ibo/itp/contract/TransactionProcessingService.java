package com.wanxg.ibo.itp.contract;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TransactionProcessingService {
	
	@WebMethod(operationName = "findTransactionList") public List<ExtTransaction> findTransactionList() throws ServiceException;
	
	@WebMethod(operationName = "findTransaction") public ExtTransaction findTransaction(Long id) throws ServiceException;
	
}
