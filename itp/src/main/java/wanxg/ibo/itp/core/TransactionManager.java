package wanxg.ibo.itp.core;

import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import wanxg.ibo.itp.core.entities.Transaction;

@Stateless
public class TransactionManager {

	@PersistenceContext(unitName = "ibo-itp")
	private EntityManager em;
	
	public List<Transaction> retrieveTransacctionList(){
		
		List<Transaction> results = new ArrayList<Transaction>();
		
		int id = 1;
		
		for (;id<4;id++){
			Transaction trn = new Transaction();
			trn.setId(Long.valueOf(id));
			trn.setCurrency("EUR");
			trn.setTransactionAmount(99.99);
			trn.setCardScheme("VISA");
			results.add(trn);
		}
		
		return results;
		
	}
	
	public void storeTransation(Transaction trn){
		
		em.persist(trn);
		
	}
}
