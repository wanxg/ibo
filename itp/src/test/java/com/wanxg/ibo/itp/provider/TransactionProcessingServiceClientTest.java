package com.wanxg.ibo.itp.provider;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import org.junit.Test;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;

public class TransactionProcessingServiceClientTest {
	
//	@WebServiceRef(wsdlLocation= "http://localhost:8080/itp/TransactionProcessingServiceProvider?wsdl")
//	TransactionProcessingService itp;
	
	@Test
	public void findTransactionTest() throws Exception{
		
		URL wsdlLocation = new URL("http://localhost:8080/itp/TransactionProcessingServiceProvider?wsdl");
		QName serviceName = new QName("http://provider.itp.ibo.wanxg.com/","TransactionProcessingService");
		Service service = Service.create(wsdlLocation,serviceName);
		TransactionProcessingService proxyService = service.getPort(TransactionProcessingService.class);
		ExtTransaction trn = proxyService.findTransaction(45l);
		System.out.println(trn.getIssuingBankId());
	}

}
