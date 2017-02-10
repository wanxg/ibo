package com.wanxg.ibo.itp.rest.transaction;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.provider.TransactionMapper;
import com.wanxg.ibo.itp.transaction.Transaction;


@Path("/itp")
@Produces("application/json")
public class TransactionProcessingRESTfulServiceProvider {
	
	@Inject
	TransactionManager tm;
	
	
	@GET
	@Path("/transactions")
	public List<ExtTransaction> findTransaction() {
		
		return TransactionMapper.mapToExtTransactionList(tm.findTransaction()) ;
	}

	
	@GET
	@Path("/transactions/{id}")
	public ExtTransaction findTransaction(@PathParam("id") Long id) {
		
		Transaction trn = tm.findTransaction(id);
		
		if(trn==null) return null;
		
		else
		
			return TransactionMapper.mapToExtTransaction(trn) ;
	}
}
