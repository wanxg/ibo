package com.wanxg.ibo.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<WebApplicationException>{

	Logger logger = LoggerFactory.getLogger(GenericExceptionMapper.class);
	
	@Override
	public Response toResponse(WebApplicationException exception) {
		
		
		logger.info(exception.getResponse().toString());
		logger.info(exception.getResponse().getEntity().toString());
		
		if(exception.getResponse()==null || exception.getResponse().getEntity()==null) {
			
				logger.error("ERROR: " + Status.INTERNAL_SERVER_ERROR.getStatusCode());
				
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
