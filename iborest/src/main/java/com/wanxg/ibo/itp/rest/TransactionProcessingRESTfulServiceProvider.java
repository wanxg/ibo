package com.wanxg.ibo.itp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;
import com.wanxg.ibo.rest.exception.TransactionNotFoundException;


@Path("/itp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionProcessingRESTfulServiceProvider {
	
	@Inject
	TransactionProcessingService itp;
	
	
	@GET
	@Path("/transactions")
	public Response findTransactionList() {
		
		List<ExtTransaction> list = itp.findTransactionList();

		if(list == null || list.isEmpty()){
			throw new TransactionNotFoundException("Transaction(s) not found!");
		}
		
		GenericEntity<List<ExtTransaction>> genericEntity = 
			        new GenericEntity<List<ExtTransaction>>(list){};
		
		return Response.ok(genericEntity).build();
		
	}

	@GET
	@Path("/transactions/{id}")
	public Response findTransaction(@PathParam("id") Long id) {
		
		ExtTransaction trn = itp.findTransaction(id);
		
		if(trn==null)
			throw new TransactionNotFoundException("Transaction not found for id: " + id);
		
		return Response.ok(trn).build();
			
	}
}
