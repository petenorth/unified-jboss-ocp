package com.redhat.ukiservices.stats.resources;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.infinispan.client.hotrod.RemoteCache;

import com.redhat.ukiservices.DarwinCache;
import com.redhat.ukiservices.RefDataCache;
import com.redhat.ukiservices.factory.DataGridClientFactory;
import com.redhat.ukiservices.model.common.impl.DarwinDataModel;
import com.redhat.ukiservices.model.common.impl.RefDataModel;

@Singleton
@Named("cacheProducer")
public class CacheProducer {

	@Inject
	@ConfigProperty(name = "DARWIN_CACHE_NAME", defaultValue = "default")
	private String darwinCacheName;

	@Inject
	@ConfigProperty(name = "REF_DATA_CACHE_NAME", defaultValue = "ref")
	private String refDataCacheName;

	@Inject
	private DataGridClientFactory factory;

	@Produces
	@DarwinCache
	public RemoteCache<String, DarwinDataModel> getDarwinCache() {
		return factory.getCache(darwinCacheName);
	}

	@Produces
	@RefDataCache
	public RemoteCache<String, RefDataModel> getRefDataCacheCache() {
		return factory.getCache(refDataCacheName);
	}
}
