package wanxg.ibo.itp.core;

import java.util.*;

import javax.ejb.Stateless;

@Stateless
public class TransactionManager {

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
}
