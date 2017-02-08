package com.wanxg.ibo.itp.rest.transaction;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.provider.TransactionMapper;


@Path("/")
public class TransactionProcessingRESTfulServiceProvider {
	
	@Inject
	TransactionManager tm;
	
	
	@GET
	@Path("/transactions")
	@Produces("application/json")
	public List<ExtTransaction> findTransaction() {
		
		return TransactionMapper.mapToExtTransactionList(tm.findTransaction()) ;
	}

}
