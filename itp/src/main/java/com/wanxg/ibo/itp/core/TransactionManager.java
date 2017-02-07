package com.wanxg.ibo.itp.core;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wanxg.ibo.itp.transaction.FirstPresentment;
import com.wanxg.ibo.itp.transaction.Transaction;
import com.wanxg.ibo.itp.transaction.UserAction;

@Stateless
public class TransactionManager {

	@PersistenceContext(unitName = "ibo-itp")
	private EntityManager em;
	

	public void storeTransation(Transaction trn){
		
		Transaction transaction = em.merge(trn);
		
		em.persist(transaction);
	}
	
	/**
	 * 
	 * 
	 */
	
	public void createTransactions(){
		
		for(int i = 1; i <= 10 ; i++){
			
			FirstPresentment fp = new FirstPresentment();
			
			fp.setCardSchemeCode("MCI");
			fp.setProcessingDate(new Date());
			fp.setBrand("Maestro");
			fp.setMultipleClearingSequenceNumber(i);
			
			
			UserAction ua = new UserAction();
			
			
			ua.setUserName("Xiaolong");
			
			fp.addUserAction(ua);
			ua.setTransaction(fp);
			
			em.merge(fp);
			
			
		}
	}
	
	public void deleteTransactions(){
		
		List<Transaction> trnList = findTransaction();
		trnList.forEach(item-> em.remove(item));
	}
	
	/**
	 * 
	 * @return
	 */
	
	public Long returnCountOfTransactions(){
		
		return (Long)em.createNamedQuery("com.wanxg.ibo.itp.transaction.Transaction.findCount").getSingleResult();
		
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Transaction> findTransaction(){
		
		System.out.println("Calling TransactionManager.findTransaction()" );
		
		List<Transaction> list = em.createNamedQuery("com.wanxg.ibo.itp.transaction.Transaction.findAll").getResultList();
		
		System.out.println("Found transaction : " + list.size() );
		
		return list;
		
	}
}
