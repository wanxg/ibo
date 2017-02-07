package com.wanxg.ibo.itp.core;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.transaction.FirstPresentment;
import com.wanxg.ibo.itp.transaction.Transaction;

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
    public  void tearDown() {
        ejbContainer.close();
        System.out.println("Closing the container" );
    }
	

	public void storeTransationTest(){
		
		Transaction trn = new FirstPresentment();
		//trn.setId(1L);
		
		tm.storeTransation(trn);
	}
	
	
	@Test
	public void deleteAllTransactionsTest(){
		
		tm.deleteTransactions();
	}
	
	@Test
	public void createTransactionsTest(){
		
		tm.createTransactions();
	}
	
	@Test
	public void findCountOfTransactionsTest(){
		
		Long i = tm.returnCountOfTransactions();
		
		System.out.println("count is " + i);
	}
	
	@Test
	public void findAllTest(){
		
		List<Transaction> list = tm.findTransaction();
		
		list.forEach(item->System.out.println(item));
	}
	


}
