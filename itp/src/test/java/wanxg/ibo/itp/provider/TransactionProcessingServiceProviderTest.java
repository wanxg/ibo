package wanxg.ibo.itp.provider;

import static org.junit.Assert.*;
import javax.inject.Inject;

import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.junit.Test;
import org.junit.runner.RunWith;

import wanxg.ibo.itp.core.TransactionManager;

@Classes(cdi = true, value = {TransactionProcessingServiceProvider.class, TransactionManager.class })
@RunWith(ApplicationComposer.class)
public class TransactionProcessingServiceProviderTest {

	@Inject
	TransactionProcessingServiceProvider itpProvider;

	@Test
	public void testAssertNotNull() {

		assertNotNull("should not be null", itpProvider.fetchTransactionList());

		itpProvider.fetchTransactionList().forEach(item -> System.out.println(item.getId() + " "
				+ item.getTransactionAmount() + " " + item.getCurrency() + " " + item.getCardScheme()));

	}

}
