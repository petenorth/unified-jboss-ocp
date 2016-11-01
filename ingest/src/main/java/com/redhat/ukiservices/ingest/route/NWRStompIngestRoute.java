package com.redhat.ukiservices.ingest.route;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.deltaspike.core.api.config.ConfigProperty;

import io.fabric8.annotations.Alias;
import io.fabric8.annotations.ServiceName;

@ContextName("IngestContext")
public class NWRStompIngestRoute extends RouteBuilder {

	@Inject
	@ConfigProperty(name = "DARWIN_QUEUE_ID", defaultValue = "D304b7bd2a-2853-4466-b590-f8cec74532af")
	private String darwinQueueId;

	@Inject
	@ConfigProperty(name = "DARWIN_HOST", defaultValue = "tcp://datafeeds.nationalrail.co.uk:61613")
	private String darwinHost;

	@Inject
	@ConfigProperty(name = "DARWIN_LOGIN", defaultValue = "d3user")
	private String darwinLogin;

	@Inject
	@ConfigProperty(name = "DARWIN_PASSCODE", defaultValue = "d3password")
	private String darwinPasscode;
	
	@Inject
	@ServiceName("broker-amq-tcp")
	@Alias("amq")
	private String amqBroker;

	@Override
	public void configure() throws Exception {

		this.getContext().setStreamCaching(false);

		from(createStompConsumer()).id("ingestRoute").processRef("nwrDataFeedProcessor").to("amq:queue:ingestdata");

	}

	/**
	 * Generate the consumer based on environment variables. 
	 * TODO refactor to
	 * use CDI
	 * 
	 * @return String stomp consumer component string
	 */
	private String createStompConsumer() {

		StringBuilder builder = new StringBuilder();

		builder.append("stomp");
		builder.append(":");
		builder.append("queue");
		builder.append(":");
		builder.append(darwinQueueId);
		builder.append("?");
		builder.append("brokerURL");
		builder.append("=");
		builder.append(darwinHost);
		builder.append("&");
		builder.append("login");
		builder.append("=");
		builder.append(darwinLogin);
		builder.append("&");
		builder.append("passcode");
		builder.append("=");
		builder.append(darwinPasscode);

		return builder.toString();
	}

}
