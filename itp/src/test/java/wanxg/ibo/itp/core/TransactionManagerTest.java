package wanxg.ibo.itp.core;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import wanxg.ibo.itp.core.entities.Transaction;

public class TransactionManagerTest {
	
	private EJBContainer container;
	private Properties p;
	private Context context;
	@Inject
	private TransactionManager tm;
	
    @Before
    public void startContainer() throws Exception {
    	
        p = new Properties();
//        p.put("ibo_itp_ds", "new://Resource?type=DataSource");
//        p.put("ibo_itp_ds.JdbcDriver", "org.hsqldb.jdbcDriver");
//        p.put("ibo_itp_ds.JdbcUrl", "jdbc:hsqldb:mem:mymemdb");
        context = EJBContainer.createEJBContainer(p).getContext();
        context.bind("inject", this);
    }
	
	@Test
	public void storeTransationTest(){
		
		Transaction trn = new Transaction();
		tm.storeTransation(trn);
//		try {
//			trn = (Transaction) context.lookup("java:global/itp/Transaction");
//			tm.storeTransation(trn);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
