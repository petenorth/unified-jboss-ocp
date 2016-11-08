package com.redhat.ukiservices.ingest.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.fusesource.hawtbuf.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("nwrDataFeedProcessor")
public class NWRDataFeedProcessor implements Processor {
	
	private static Logger LOG = LoggerFactory.getLogger(NWRDataFeedProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();
		
		Buffer buffer = (Buffer) in.getBody();
		
		GZIPInputStream gis = new GZIPInputStream(buffer.in());

		BufferedReader reader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

		String line;
		
		StringBuilder sb = new StringBuilder();

		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		String body = sb.toString();
		
		LOG.debug(body);
		
		in.setBody(body);
		
		exchange.setIn(in);
	}

}
