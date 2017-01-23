package wanxg.ibo.itp.provider;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import wanxg.ibo.itp.contract.TransactionProcessingService;


public class TransactionProcessingServiceProviderTest {

	private EJBContainer container;
	
	@Inject
	TransactionProcessingService itpProvider;

    @Before
    public void startContainer() throws Exception {
        container = EJBContainer.createEJBContainer();
        container.getContext().bind("inject", this);
    }
	
	@Test
	public void testAssertNotNull() {

		assertNotNull("should not be null", itpProvider.fetchTransactionList());

		itpProvider.fetchTransactionList().forEach(item -> System.out.println(item.getId() + " "
				+ item.getTransactionAmount() + " " + item.getCurrency() + " " + item.getCardScheme()));

	}

}
