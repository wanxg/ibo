package com.wanxg.ibo.itp.contract;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TransactionProcessingService {
	@WebMethod public List<ExtTransaction> findTransaction();
}
