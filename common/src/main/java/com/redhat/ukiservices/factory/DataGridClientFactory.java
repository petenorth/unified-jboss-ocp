package com.redhat.ukiservices.factory;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
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
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.model.common.DarwinDataType;
import com.redhat.ukiservices.model.common.RefDataType;
import com.redhat.ukiservices.model.common.impl.DarwinDataModel;
import com.redhat.ukiservices.model.common.impl.RefDataModel;

import io.fabric8.annotations.ServiceName;

@Singleton
@Named("dgClientFactory")
public class DataGridClientFactory {

	private static final Logger LOG = LoggerFactory.getLogger(DataGridClientFactory.class);

	@Inject
	@ServiceName("datagrid-app-hotrod")
	private String dgCacheService;

	private RemoteCacheManager cacheManager;

	public <T extends Object> RemoteCache<String, T> getCache(String cacheName) {
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

	private void registerProtoBufSchema() {
		SerializationContext serCtx = ProtoStreamMarshaller.getSerializationContext(cacheManager);

		String generatedSchema = null;
		try {
			ProtoSchemaBuilder protoSchemaBuilder = new ProtoSchemaBuilder();
			generatedSchema = protoSchemaBuilder.fileName("darwinschema.proto").packageName("etl")
					.addClass(RefDataType.class).addClass(DarwinDataType.class).addClass(RefDataModel.class)
					.addClass(DarwinDataModel.class).build(serCtx);

			// register the schemas with the server too
			RemoteCache<String, String> metadataCache = cacheManager
					.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);

			metadataCache.put("darwinschema.proto", generatedSchema);

		} catch (IOException e1) {
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
