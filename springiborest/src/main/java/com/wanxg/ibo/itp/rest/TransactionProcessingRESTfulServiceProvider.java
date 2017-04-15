package com.wanxg.ibo.itp.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.ServiceException;
import com.wanxg.ibo.rest.exception.ErrorMessage;

@Component
@Path("/itp")
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionProcessingRESTfulServiceProvider {

//	@Inject
//	TransactionProcessingService itp;

	Logger logger = LoggerFactory.getLogger(TransactionProcessingRESTfulServiceProvider.class);
	
	@GET
	@Path("/transactions")
	public Response findTransactionList() {

		List<ExtTransaction> list;
		
		try {
			list = TransactionProcessingServiceConsumer.findTransactionList();
		} catch (ServiceException e) {
			logger.error("ERROR: ServiceException thrown from ITP.");
			ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.getStatusCode(), e.getMessage());
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(errorMessage).build());
		
		} catch (Exception e) {
			logger.error("ERROR: General Exception Caught.");
			ErrorMessage errorMessage = new ErrorMessage(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build());
		} 
		
		logger.info(list.size() + " transaction(s) found");
		return Response.ok(new GenericEntity<List<ExtTransaction>>(list) {}).build();
		
	}
	
	@GET
	@Path("/transactions/{id}")
	public Response findTransaction(@PathParam("id") Long id, @Context UriInfo uriInfo) {

		ExtTransaction trn;
		try {
			trn = TransactionProcessingServiceConsumer.findTransaction(id);
		} catch (ServiceException e) {
			// throw new TransactionNotFoundException("Transaction not found for id: " + id);

			logger.error("ERROR: ServiceException thrown from ITP.");
			ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.getStatusCode(), e.getMessage());
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(errorMessage).build());
			
		} catch (Exception e) {
			
			logger.error("ERROR: General Exception Caught.");
			ErrorMessage errorMessage = new ErrorMessage(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build());
		}
	
		/*
		URI uri = uriInfo.getBaseUriBuilder()
				.path(TransactionProcessingRESTfulServiceProvider.class)
				.path(TransactionProcessingRESTfulServiceProvider.class, "findTransaction")
				.resolveTemplate("id", id)
				.build();

		System.out.println(uri.getPath());
		*/
		
		logger.info("Found transaction for id: " + id);
		
		return Response.ok(trn).build();

	}
}
