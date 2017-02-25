package com.wanxg.ibo.idm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/idm")
@Produces("application/json")
public class DisputeManagementRESTfulServiceProvider {

	
	@POST
	@Path("{id}")
	@Consumes({"application/xml", "application/json", "application/text"})
	
	public Long disputeTransaction(@PathParam("id") Long id){
		
		System.out.println("Retrieved transaction id : " + id + " from HTTP POST." );
		
		return id;
		
	}
	
}
