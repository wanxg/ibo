package com.wanxg.ibo.itp.rest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wanxg.ibo.itp.contract.ExtTransaction;
import com.wanxg.ibo.itp.contract.ServiceException;
import com.wanxg.ibo.itp.contract.TransactionProcessingService;

public class TransactionProcessingServiceConsumer {
	
	private static final String ITP_WS_URL = "http://localhost:9999/itp/TransactionProcessingServiceProvider?wsdl";
	private static final String ITP_WS_QNAME = "http://provider.itp.ibo.wanxg.com/";
	private static final String ITP_WS_NAME = "TransactionProcessingService";

	public static ExtTransaction findTransaction(long id) throws ServiceException, MalformedURLException, Exception {
		TransactionProcessingService proxyService = createService().getPort(TransactionProcessingService.class);
		ExtTransaction trn = proxyService.findTransaction(id);
		return trn;
	}

	public static List<ExtTransaction> findTransactionList() throws ServiceException, MalformedURLException {
		TransactionProcessingService proxyService = createService().getPort(TransactionProcessingService.class);
		List<ExtTransaction> list = proxyService.findTransactionList();
		return list;
	}
	
	private static Service createService() throws MalformedURLException{
		URL wsdlLocation = new URL(ITP_WS_URL);
		QName serviceName = new QName(ITP_WS_QNAME, ITP_WS_NAME);
		Service service = Service.create(wsdlLocation, serviceName);
		return service;
	}

}
