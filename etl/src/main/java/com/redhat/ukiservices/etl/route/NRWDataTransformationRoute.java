package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;
import javax.xml.bind.UnmarshalException;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.dataformat.JaxbDataFormat;

import io.fabric8.annotations.Alias;
import io.fabric8.annotations.ServiceName;

@ContextName("ETLContext")
public class NRWDataTransformationRoute extends RouteBuilder {

	@Inject
	@ServiceName("broker-amq-tcp")
	@Alias("amq")
	private ActiveMQComponent activeMQComponent;

	@Override
	public void configure() throws Exception {

		this.getContext().setStreamCaching(true);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		jaxbDataFormat.setContextPath("com.redhat.ukiservices.etl.model");
		jaxbDataFormat.setMustBeJAXBElement(false);
		
		onException(UnmarshalException.class).log("Exception caught during transformation. Is the message the right format?");
		
		from("amq:queue:ingestdata")
			.unmarshal(jaxbDataFormat)
			.log("${body}");

	}

}
