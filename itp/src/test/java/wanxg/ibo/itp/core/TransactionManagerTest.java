package wanxg.ibo.itp.core;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import wanxg.ibo.itp.core.entities.Transaction;

public class TransactionManagerTest {
	
	private EJBContainer container;
	
	@Inject
	private TransactionManager tm;
	
    @Before
    public void startContainer() throws Exception {
        container = EJBContainer.createEJBContainer();
        container.getContext().bind("inject", this);
    }
	
	@Test
	public void storeTransationTest(){
		
		Transaction trn = new Transaction();
		tm.storeTransation(trn);
		
	}

}
