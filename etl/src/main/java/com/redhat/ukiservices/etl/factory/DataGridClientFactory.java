package com.redhat.ukiservices.etl.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
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
	@ServiceName("datagrid-app-hotrod")
	private String dgCacheService;

	@Inject
	@ConfigProperty(name = "DARWIN_CACHE_NAME", defaultValue = "default")
	private String darwinCacheName;

	private RemoteCacheManager cacheManager;

	@Produces
	@DarwinCache
	public RemoteCache<String, Object> getCache() {
		return cacheManager.getCache(darwinCacheName);
	}

	@PostConstruct
	protected void postConstruct() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServers(getJDGService());
		builder.nearCache().mode(NearCacheMode.LAZY).maxEntries(500);
		cacheManager = new RemoteCacheManager(builder.build());
	}

	/**
	 * Couldn't think of an elegant way to build the service URL using the
	 * Fabric8 guff.
	 * 
	 * @return A string representing the JDG Kubernetes service...without the
	 *         tcp:// protocol prefix
	 */
	private String getJDGService() {
		String urlPattern = "(tcp):((//)*)";
		Pattern p = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(dgCacheService);
		int i = 0;
		String regexedServiceName = null;
		while (m.find()) {
			regexedServiceName = dgCacheService.replaceAll(m.group(i), "").trim();
			i++;
		}
		return regexedServiceName;
	}

}
