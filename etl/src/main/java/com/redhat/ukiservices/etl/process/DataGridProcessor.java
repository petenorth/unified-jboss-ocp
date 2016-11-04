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
import com.redhat.ukiservices.etl.model.StationMessage;
import com.redhat.ukiservices.etl.model.TS;

@Singleton
@Named("dataGridProcessor")
public class DataGridProcessor implements Processor {

	private static Logger LOG = LoggerFactory.getLogger(DataGridProcessor.class);

	@Inject
	@DarwinCache
	private RemoteCache<String, Object> darwinCache;

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();
		String objectType = (String) in.getHeader(EtlConstants.TYPE_HEADER_KEY);
		if (objectType != null) {
			String id = null;
			if (objectType.equalsIgnoreCase(EtlConstants.TYPE_HEADER_TS)) {
				TS ts = (TS) in.getBody();
				id = ts.getRid();

			} else if (objectType.equalsIgnoreCase(EtlConstants.TYPE_HEADER_OW)) {
				StationMessage ow = (StationMessage) in.getBody();
				id = String.valueOf(ow.getId());

			}
			darwinCache.put(this.generateKey(id), in.getBody());
		}

	}

	/**
	 * Generates some suitably arbitrary key.
	 * 
	 * @param id
	 * @return
	 */
	private String generateKey(String id) {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append(":");
		sb.append(System.currentTimeMillis());

		return sb.toString();
	}

}
