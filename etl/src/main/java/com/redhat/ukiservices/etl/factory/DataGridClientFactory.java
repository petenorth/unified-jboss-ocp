package com.redhat.ukiservices.etl.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.configuration.NearCacheMode;

import com.redhat.ukiservices.etl.DarwinCache;

import io.fabric8.annotations.ServiceName;

@Singleton
@Named("dgClientFactory")
public class DataGridClientFactory {

	@Inject
	@ConfigProperty(name = "DATAGRID_HOTROD_SERVICE", defaultValue = "datagrid-app:11333")
	private String dgCacheService;

	@Inject
	@ConfigProperty(name = "DARWIN_CACHE_NAME", defaultValue = "default")
	private String darwinCacheName;

	private RemoteCacheManager cacheManager;

	private DataGridClientFactory() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServers(dgCacheService);
		builder.nearCache().mode(NearCacheMode.LAZY);
		cacheManager = new RemoteCacheManager(builder.build());
	}

	@Produces
	@DarwinCache
	public RemoteCache<String, Object> getCache() {
		return cacheManager.getCache(darwinCacheName);
	}

}
