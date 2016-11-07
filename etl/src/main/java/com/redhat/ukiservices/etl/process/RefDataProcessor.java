package com.redhat.ukiservices.etl.process;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.infinispan.client.hotrod.RemoteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.etl.EtlConstants;
import com.redhat.ukiservices.etl.RefDataCache;
import com.redhat.ukiservices.etl.model.common.RefDataType;
import com.redhat.ukiservices.etl.model.common.impl.RefDataModel;
import com.redhat.ukiservices.etl.model.jaxb.ref.LocationRef;
import com.redhat.ukiservices.etl.model.jaxb.ref.PportTimetableRef;
import com.redhat.ukiservices.etl.model.jaxb.ref.Reason;

@Singleton
@Named("refDataProcessor")
public class RefDataProcessor implements Processor {

	private static final Logger LOG = LoggerFactory.getLogger(RefDataProcessor.class);

	private static final String UPDATE_COUNT_MSG = "Refreshed reference data in %d ms: %n Late Reasons: %d %n Cancellation Reasons: %d %n Location Data: %d";

	@Inject
	@RefDataCache
	private RemoteCache<String, RefDataModel> refDataCache;

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		PportTimetableRef payload = (PportTimetableRef) in.getBody();

		long start = System.currentTimeMillis();
		int lrCount = 0;
		for (Reason reason : payload.getLateRunningReasons().getReason()) {
			RefDataType type = RefDataType.LATEREASON;
			String code = String.valueOf(reason.getCode());
			String value = reason.getReasontext();

			RefDataModel lrr = new RefDataModel(type, code, value);
			refDataCache.put(generateKey(type, code), lrr);
			lrCount++;
		}

		int crCount = 0;
		for (Reason reason : payload.getCancellationReasons().getReason()) {

			RefDataType type = RefDataType.CANCELLATIONREASON;
			String code = String.valueOf(reason.getCode());
			String value = reason.getReasontext();

			RefDataModel cr = new RefDataModel(type, code, value);
			refDataCache.put(generateKey(type, code), cr);
			crCount++;
		}

		int locCount = 0;
		for (LocationRef loc : payload.getLocationRef()) {

			RefDataType type = RefDataType.LOCATION;
			String code = loc.getTpl();
			String value = loc.getLocname();
			String crs = loc.getCrs();

			if (crs != null) {
				Map<String, String> codes = new HashMap<>();
				codes.put(RefDataType.CRS.toString(), crs);
			}

			RefDataModel locRef = new RefDataModel(type, code, value);
			refDataCache.put(generateKey(type, code), locRef);
			locCount++;
		}
		long end = System.currentTimeMillis();
		long duration = end - start;

		LOG.info(String.format(UPDATE_COUNT_MSG, duration, lrCount, crCount, locCount));

	}

	private String generateKey(RefDataType type, String code) {
		StringBuilder sb = new StringBuilder();

		sb.append(type.toString());
		sb.append(EtlConstants.KEY_DELIMITER);
		sb.append(code);

		return sb.toString();

	}

}
