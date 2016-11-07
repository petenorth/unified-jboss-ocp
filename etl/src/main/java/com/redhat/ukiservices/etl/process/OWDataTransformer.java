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
import com.redhat.ukiservices.etl.model.jaxb.StationMessage;
import com.redhat.ukiservices.etl.model.jaxb.StationMessage.Station;

@Singleton
@Named("owDataTransformer")
public class OWDataTransformer implements Processor {

	private static Logger LOG = LoggerFactory.getLogger(OWDataTransformer.class);

	@Inject
	@RefDataCache
	private RemoteCache<String, RefDataModel> refDataCache;

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();

		StationMessage ow = (StationMessage) in.getBody();
		String id = String.valueOf(ow.getId());
		StringBuilder sb = new StringBuilder();
		for (Object content : ow.getMsg().getContent())
		{
			sb.append(content.toString());
		}
		
		List<String> locations = new ArrayList<>();
		
		for (Station station: ow.getStation())
		{
			locations.add(station.getCrs());
		}
		
		DarwinDataModel model = new DarwinDataModel(DarwinDataType.STATIONMESSAGE,id,sb.toString(), locations); 
		
		in.setBody(model);
		exchange.setIn(in);
	}

}
