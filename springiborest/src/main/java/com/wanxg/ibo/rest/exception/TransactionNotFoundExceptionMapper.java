package com.wanxg.ibo.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TransactionNotFoundExceptionMapper implements ExceptionMapper<TransactionNotFoundException> {

	@Override
	public Response toResponse(TransactionNotFoundException exception) {
		
		ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.getStatusCode(), exception.getMessage());
		
		return Response
				.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
