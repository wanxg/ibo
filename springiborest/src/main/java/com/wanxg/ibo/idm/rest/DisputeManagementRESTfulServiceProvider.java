package com.wanxg.ibo.idm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

@Component
@Path("/idm")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisputeManagementRESTfulServiceProvider {
	
	@POST
	@Path("{id}")
	public Long disputeTransaction(@PathParam("id") Long id){
		
		System.out.println("Retrieved transaction id : " + id + " from HTTP POST." );
		
		return id;
		
	}
	
	@GET
	@Path("/{random}/{number}")
	public Response getNumber(@PathParam("random") String random,@PathParam("number") Long number,@Context UriInfo uriInfo){
		
		System.out.println("HTTP GET: " + uriInfo.getAbsolutePath());
		
		return Response.ok("Response: " + number).build();
		
	}
	
}
