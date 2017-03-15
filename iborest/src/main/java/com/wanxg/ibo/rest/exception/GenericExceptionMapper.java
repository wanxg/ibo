package com.wanxg.ibo.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<WebApplicationException>{

	@Override
	public Response toResponse(WebApplicationException exception) {
		
		
		if(exception.getResponse()==null || exception.getResponse().getEntity()==null) {
			
				ErrorMessage errorMessage = new ErrorMessage(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
						exception.getMessage()==null || exception.getMessage().isEmpty()? Status.INTERNAL_SERVER_ERROR.toString():exception.getMessage());

				return Response
						.status(Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage)
						.type(MediaType.APPLICATION_JSON)
						.build();
		}
		
		else
			return exception.getResponse();
		
	}

}
