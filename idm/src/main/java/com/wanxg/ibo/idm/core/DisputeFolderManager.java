package com.wanxg.ibo.idm.core;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wanxg.ibo.idm.disputecycle.DisputeFolder;

@Stateless
public class DisputeFolderManager {
	
	
	@PersistenceContext(unitName = "ibo-idm")
	private EntityManager em;
	
	public void createDisputeFolder(DisputeFolder df){
		
		df.setCreateDate(new Date());
		
		df.setDisputed(true);
		
		em.persist(df);
	}

}
