package com.redhat.ukiservices.etl.process;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.infinispan.client.hotrod.RemoteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.etl.DarwinCache;
import com.redhat.ukiservices.etl.EtlConstants;
import com.redhat.ukiservices.etl.model.common.DarwinDataType;
import com.redhat.ukiservices.etl.model.common.impl.DarwinDataModel;

@Singleton
@Named("datagridPutProcessor")
public class DataGridPutProcessor implements Processor {

	private static final Logger LOG = LoggerFactory.getLogger(DataGridPutProcessor.class);
	private static final String DATA_PUT_MSG = "PUT: %s";

	@Inject
	@DarwinCache
	private RemoteCache<String, DarwinDataModel> darwinCache;

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		DarwinDataModel model = (DarwinDataModel) in.getBody();
		String key = generateDarwinDataKey(model.getDarwinDataType(), model.getId());
		darwinCache.put(key, model);
		LOG.info(String.format(DATA_PUT_MSG, model.toString()));
		

	}

	private String generateDarwinDataKey(DarwinDataType type, String id) {
		StringBuilder sb = new StringBuilder();

		sb.append(type.toString());
		sb.append(EtlConstants.KEY_DELIMITER);
		sb.append(id);

		return sb.toString();

	}

}
