
package com.wanxg.ibo.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanxg.ibo.idm.rest.DisputeManagementRESTfulServiceProvider;
import com.wanxg.ibo.itp.rest.TransactionProcessingRESTfulServiceProvider;

@Component
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

	@Autowired
	public ApplicationConfig(ObjectMapper objectMapper) {
		// register endpoints
		//packages("com.wanxg.ibo");
		register(TransactionProcessingRESTfulServiceProvider.class);
		register(DisputeManagementRESTfulServiceProvider.class);
		
		
		// register jackson for json
		register(new ObjectMapperContextResolver(objectMapper));
	}

	@Provider
	public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

		private final ObjectMapper mapper;

		public ObjectMapperContextResolver(ObjectMapper mapper) {
			this.mapper = mapper;
		}

		@Override
		public ObjectMapper getContext(Class<?> type) {
			return mapper;
		}
	}
}
