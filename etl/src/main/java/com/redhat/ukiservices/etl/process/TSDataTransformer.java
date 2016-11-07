package com.redhat.ukiservices.etl.process;

import java.util.ArrayList;
import java.util.List;

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
import com.redhat.ukiservices.etl.model.common.DarwinDataType;
import com.redhat.ukiservices.etl.model.common.RefDataType;
import com.redhat.ukiservices.etl.model.common.impl.DarwinDataModel;
import com.redhat.ukiservices.etl.model.common.impl.RefDataModel;
import com.redhat.ukiservices.etl.model.jaxb.DisruptionReasonType;
import com.redhat.ukiservices.etl.model.jaxb.TS;
import com.redhat.ukiservices.etl.model.jaxb.TSLocation;

@Singleton
@Named("tsDataTransformer")
public class TSDataTransformer implements Processor {

	private static Logger LOG = LoggerFactory.getLogger(TSDataTransformer.class);

	@Inject
	@RefDataCache
	private RemoteCache<String, RefDataModel> refDataCache;

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();

		TS ts = (TS) in.getBody();
		String id = ts.getRid();

		DisruptionReasonType lateReason = ts.getLateReason();

		String lateReasonMessage = null;
		if (lateReason != null) {
			String messageKey = generateRefDataKey(RefDataType.LATEREASON, String.valueOf(lateReason.getValue()));
			RefDataModel refDataLateReason = refDataCache.get(messageKey);
			if (refDataLateReason != null)
			{
				lateReasonMessage = refDataLateReason.getValue();
			}
			
		}

		List<String> locations = new ArrayList<>();

		for (TSLocation loc : ts.getLocation()) {

			String locKey = generateRefDataKey(RefDataType.LOCATION, loc.getTpl());
			RefDataModel location = refDataCache.get(locKey);
			if (location != null) {
				locations.add(location.getValue());
			}
		}

		DarwinDataModel model = new DarwinDataModel(DarwinDataType.TRAINSTATUS, id, lateReasonMessage, locations);
		
		in.setBody(model);
		exchange.setIn(in);

	}

	private String generateRefDataKey(RefDataType type, String code) {
		StringBuilder sb = new StringBuilder();

		sb.append(type.toString());
		sb.append(EtlConstants.KEY_DELIMITER);
		sb.append(code);

		return sb.toString();

	}

}
