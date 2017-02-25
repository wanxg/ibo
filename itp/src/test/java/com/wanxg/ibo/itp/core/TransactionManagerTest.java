package com.wanxg.ibo.itp.core;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.transaction.FirstPresentment;
import com.wanxg.ibo.itp.transaction.Transaction;
import com.wanxg.ibo.itp.transaction.UserAction;

public class TransactionManagerTest {

	private Properties p;
	private Context context;
	private EJBContainer ejbContainer;

	@Inject
	private TransactionManager tm;

	@Before
	public void startUp() throws Exception {

		p = new Properties();
		p.put("ibo_itp_ds", "new://Resource?type=DataSource");
		p.put("ibo_itp_ds.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("ibo_itp_ds.JdbcUrl", "jdbc:hsqldb:file:D:/hsqldb-2.3.4/itpdb;shutdown=true;hsqldb.write_delay=false");

		ejbContainer = EJBContainer.createEJBContainer(p);
		context = ejbContainer.getContext();
		context.bind("inject", this);
	}

	@After
	public void tearDown() {
		ejbContainer.close();
		System.out.println("Closing the container");
	}

	public void storeTransationTest() {

		Transaction trn = new FirstPresentment();
		// trn.setId(1L);

		tm.storeTransation(trn);
	}

	@Test
	public void deleteAllTransactionsTest() {

		tm.deleteTransactions();
	}

	@Test
	public void createTransactionsTest() {

		tm.createTransactions();
	}

	@Test
	public void findCountOfTransactionsTest() {

		Long i = tm.returnCountOfTransactions();

		System.out.println("count is " + i);
	}

	@Test
	public void findAllTest() {

		List<Transaction> list = tm.findTransaction();

		list.forEach(item -> System.out.println(item));
	}

	@Test
	public void findTransactionByIdTest() {

		Long id = 218l;

		Transaction trn = tm.findTransaction(id);

		Assert.assertNotNull(trn);

		System.out.println("Is trn initialized? " + Hibernate.isInitialized(trn));

		System.out.println("Is trn instance of HibernateProxy? " + (trn instanceof HibernateProxy ? true : false));

		Set<UserAction> actions = trn.getUserActions();

		System.out.println("Is actions initialized? " + Hibernate.isInitialized(actions));

		Hibernate.initialize(actions);
		
		
		System.out.println("Is actions instance of HibernateProxy? " + (actions instanceof HibernateProxy ? true : false));
		
		HibernateProxy proxy = (HibernateProxy) actions;
		
		Set unproxedActions = (Set)proxy.getHibernateLazyInitializer().getImplementation();
		

		Assert.assertEquals("size should be 1", 1, unproxedActions.size());

	}

	@Test
	public void findUserActionsForTransactionTest() {

		Long id = 218l;

		Set<UserAction> actions = tm.findUserActionSetForTrnsaction(id);

		System.out.println("Is it initialized? " + Hibernate.isInitialized(actions));

		System.out.println("Is it instance of HibernateProxy? " + (actions instanceof HibernateProxy ? true : false));

		actions.forEach(item -> System.out.println("User of action is " + item.getUserName()));

	}

}
