package com.wanxg.ibo.itp.core;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;

import com.wanxg.ibo.itp.exception.BusinessException;
import com.wanxg.ibo.itp.transaction.Amount;
import com.wanxg.ibo.itp.transaction.Card;
import com.wanxg.ibo.itp.transaction.FirstPresentment;
import com.wanxg.ibo.itp.transaction.TerminalCategory;
import com.wanxg.ibo.itp.transaction.Transaction;
import com.wanxg.ibo.itp.transaction.TransactionType;
import com.wanxg.ibo.itp.transaction.UserAction;

@Stateless
public class TransactionManager {

	@PersistenceContext(unitName = "ibo-itp")
	private EntityManager em;

	public void storeTransation(Transaction trn) {

		Transaction transaction = em.merge(trn);

		em.persist(transaction);
	}

	/**
	 * 
	 * 
	 */

	public void createTransactions() {
		
		Card card = new Card();

		card.setCardNumber(5105105105105100L);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		card.setExpiryDate(cal.getTime());
		card.setSequenceNumber(1);
		
		em.persist(card);

		for (int i = 1; i <= 10; i++) {

			FirstPresentment fp = new FirstPresentment();

			fp.setCardSchemeCode("MCI");
			fp.setProcessingDate(new Date());
			fp.setTransactionLocalDateAndTime(new Date());
			fp.setBrand("Maestro");
			fp.setMerchant("REWE FRANKFURT");
			fp.setTransactionType(TransactionType.SALES);
			fp.setTerminalCategory(TerminalCategory.POS);
			
			Amount amount = new Amount(10000l,2,"EUR");
			fp.setTransactionAmount(amount);
			fp.setIssuingBankId(88888);
			
			UserAction ua = new UserAction();

			ua.setUserName("Xiaolong");

			fp.addUserAction(ua);
			ua.setTransaction(fp);

			em.persist(fp);

			fp.setCard(card);
			
		}
	}

	public void deleteTransactions() {

		List<Transaction> trnList;
		try {
			trnList = findTransaction();
		} catch (BusinessException e) {
			return;
		}
		trnList.forEach(item -> em.remove(item));
	}
	
	public void deleteTransaction(long id) throws BusinessException{
		
		em.remove(findTransaction(id));
	}

	/**
	 * 
	 * @return
	 */

	public Long returnCountOfTransactions() {

		return (Long) em.createNamedQuery("com.wanxg.ibo.itp.transaction.Transaction.findCount").getSingleResult();

	}

	/**
	 * 
	 * @return
	 * @throws BusinessException 
	 */
	@SuppressWarnings("unchecked")
	public List<Transaction> findTransaction() throws BusinessException {

		System.out.println("Calling TransactionManager.findTransaction()");

		List<Transaction> list = em.createNamedQuery("com.wanxg.ibo.itp.transaction.Transaction.findAll")
				.getResultList();
		
		if(list==null || list.isEmpty())
			
			throw new BusinessException("Info: Transation(s) Not Found");

		System.out.println("Found transactions : " + list.size());

		return list;

	}
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public Transaction findTransaction(Long id) throws BusinessException{
		
		if(id<0)
			
			throw new BusinessException("Invalid Transation Id");
		
		Transaction trn = em.find(Transaction.class, id);
		
		if(trn==null)
			
			throw new BusinessException("Info: Transation Not Found for Id : " + id);
		
		return trn;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public Set<UserAction> findUserActionSetForTrnsaction(Long id) throws BusinessException{
		
		Set<UserAction> actions = this.findTransaction(id).getUserActions();
		
		return actions;
		
	}
}
