package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

@ContextName("etlContext")
public class JDGStatsRoute extends RouteBuilder {

	@Inject
	@Uri("timer://stats?fixedRate=true&period=120s&delay=30s")
	private Endpoint scheduler;

	@Override
	public void configure() throws Exception {
		from(scheduler)
		.id("jdgStatsRoute")
		.processRef("dgStatsProcessor")
		.log("${body}");

	}

}
