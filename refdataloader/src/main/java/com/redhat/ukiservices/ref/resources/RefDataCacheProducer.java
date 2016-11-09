package com.redhat.ukiservices.ref.resources;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.infinispan.client.hotrod.RemoteCache;

import com.redhat.ukiservices.RefDataCache;
import com.redhat.ukiservices.factory.DataGridClientFactory;
import com.redhat.ukiservices.model.common.impl.RefDataModel;


@Singleton
@Named("refDataCacheProducer")
public class RefDataCacheProducer {


	@Inject
	@ConfigProperty(name = "REF_DATA_CACHE_NAME", defaultValue = "ref")
	private String refDataCacheName;
	
	@Inject
	private DataGridClientFactory factory;


	@Produces
	@RefDataCache
	public RemoteCache<String, RefDataModel> getRefDataCache() {
		return factory.getCache(refDataCacheName);
	}
}
