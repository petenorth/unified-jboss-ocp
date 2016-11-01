package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import io.fabric8.annotations.Alias;
import io.fabric8.annotations.ServiceName;

@ContextName("IngestContext")
public class NRWDataTransformationRoute extends RouteBuilder {

	@Inject
	@ServiceName("broker-amq-tcp")
	@Alias("amq")
	private ActiveMQComponent activeMQComponent;

	@Override
	public void configure() throws Exception {

		this.getContext().setStreamCaching(true);
		
		onException(Exception.class).log("Exception caught during transformation. Is the message the right format?");
		
		from("amq:queue:ingestdata")
			.unmarshal()
			.jaxb("com.redhat.ukiservices.etl.model")
			.log("${body}");

	}

}
