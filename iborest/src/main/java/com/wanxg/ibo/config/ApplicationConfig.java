package com.wanxg.ibo.config;

import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wanxg.ibo.idm.rest.DisputeManagementRESTfulServiceProvider;
import com.wanxg.ibo.itp.rest.TransactionProcessingRESTfulServiceProvider;

@ApplicationPath("/")
public class ApplicationConfig extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(
        		TransactionProcessingRESTfulServiceProvider.class,
        		DisputeManagementRESTfulServiceProvider.class));
    }

}
