package com.wanxg.ibo.itp.provider;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wanxg.ibo.itp.contract.TransactionProcessingService;


public class TransactionProcessingServiceProviderTest {

	private Properties p;
	private Context context;
	private EJBContainer ejbContainer;
	
	@Inject
	TransactionProcessingService itpProvider;

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
	
	@Test
	public void testAssertNotNull() {

		assertNotNull("should not be null", itpProvider.findTransaction());

		itpProvider.findTransaction().forEach(item -> System.out.println(item.getId() + " "
				+ item.getBrand() + " " + item.getCardSchemeCode() + " " + item.getProcessingDate()));

	}

}
