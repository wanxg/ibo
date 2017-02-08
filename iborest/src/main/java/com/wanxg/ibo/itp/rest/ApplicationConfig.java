package com.wanxg.ibo.itp.rest;

import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wanxg.ibo.itp.rest.transaction.TransactionProcessingRESTfulServiceProvider;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
	
	@Override
    @SuppressWarnings("unchecked")
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(TransactionProcessingRESTfulServiceProvider.class));
    }

}
