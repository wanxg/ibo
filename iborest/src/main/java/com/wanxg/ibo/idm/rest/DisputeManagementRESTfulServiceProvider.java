package com.wanxg.ibo.idm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}
