package com.redhat.ukiservices.etl.factory;

import java.io.IOException;
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
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.annotations.ProtoSchemaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.etl.DarwinCache;
import com.redhat.ukiservices.etl.RefDataCache;
import com.redhat.ukiservices.etl.model.common.DarwinDataType;
import com.redhat.ukiservices.etl.model.common.RefDataType;
import com.redhat.ukiservices.etl.model.common.impl.DarwinDataModel;
import com.redhat.ukiservices.etl.model.common.impl.RefDataModel;

import io.fabric8.annotations.ServiceName;

@Singleton
@Named("dgClientFactory")
public class DataGridClientFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataGridClientFactory.class);

	@Inject
	@ServiceName("datagrid-app-hotrod")
	private String dgCacheService;

	@Inject
	@ConfigProperty(name = "DARWIN_CACHE_NAME", defaultValue = "default")
	private String darwinCacheName;

	@Inject
	@ConfigProperty(name = "REF_DATA_CACHE_NAME", defaultValue = "ref")
	private String refDataCacheName;

	private RemoteCacheManager cacheManager;

	@Produces
	@DarwinCache
	public RemoteCache<String, DarwinDataModel> getDarwinCache() {
		return cacheManager.getCache(darwinCacheName);
	}

	@Produces
	@RefDataCache
	public RemoteCache<String, RefDataModel> getRefDataCache() {
		return cacheManager.getCache(refDataCacheName);
	}

	public RemoteCache<String, Object> getCache(String cacheName) {
		return cacheManager.getCache(cacheName);
	}

	@PostConstruct
	protected void postConstruct() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServers(getJDGService());
		builder.nearCache().mode(NearCacheMode.LAZY).maxEntries(500);
		builder.marshaller(new ProtoStreamMarshaller());
		cacheManager = new RemoteCacheManager(builder.build());
		
		registerProtoBufSchema();
		
	}
	
	
	private void registerProtoBufSchema()
	{
		SerializationContext serCtx = 
			    ProtoStreamMarshaller.getSerializationContext(cacheManager);
		
		String generatedSchema = null;
		try
		{
			ProtoSchemaBuilder protoSchemaBuilder = new ProtoSchemaBuilder();
			generatedSchema = protoSchemaBuilder
			    .fileName("darwinschema.proto")
			    .packageName("etl")
			    .addClass(RefDataType.class)
			    .addClass(DarwinDataType.class)
			    .addClass(RefDataModel.class)
			    .addClass(DarwinDataModel.class)
			    .build(serCtx);
		}
		catch(IOException e1)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("No schema generated because of Exception:");
			sb.append(e1.getMessage());
			generatedSchema = sb.toString();
		}

		
		LOG.info(generatedSchema);
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
