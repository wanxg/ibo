package wanxg.ibo.itp.provider;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import wanxg.ibo.itp.contract.ExtTransaction;
import wanxg.ibo.itp.contract.TransactionProcessingService;
import wanxg.ibo.itp.core.TransactionManager;

@Stateless
@WebService(serviceName = "TransactionProcessingService",endpointInterface = "wanxg.ibo.itp.contract.TransactionProcessingService")
public class TransactionProcessingServiceProvider implements TransactionProcessingService {

	@Inject
	TransactionManager tm;
	
	public List<ExtTransaction> fetchTransactionList() {
		
		return TransactionMapper.mapToExtTransactionList(tm.retrieveTransacctionList()) ;
	}

}
