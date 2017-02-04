package com.wanxg.ibo.itp.provider;

import static org.junit.Assert.*;
import javax.inject.Inject;

import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.wanxg.ibo.itp.contract.TransactionProcessingService;
import com.wanxg.ibo.itp.core.TransactionManager;
import com.wanxg.ibo.itp.provider.TransactionProcessingServiceProvider;

@Classes(cdi = true, value = {TransactionProcessingServiceProvider.class, TransactionManager.class })
@RunWith(ApplicationComposer.class)
public class TransactionProcessingServiceProviderTestOld {

	@Inject
	TransactionProcessingService itpProvider;

	@Test
	public void testAssertNotNull() {

		assertNotNull("should not be null", itpProvider.findTransaction());

		itpProvider.findTransaction().forEach(item -> System.out.println(item.getId() + " "
				+ item.getBrand() + " " + item.getCardSchemeCode() + " " + item.getProcessingDate()));
	}

}