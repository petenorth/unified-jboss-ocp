package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.Uri;

public class JDGStatsRoute extends RouteBuilder {

	@Inject
	@Uri("scheduler://foo?period=120s")
	private Endpoint scheduler;

	@Override
	public void configure() throws Exception {
		from(scheduler)
		.id("jdgStatsRoute")
		.processRef("jdgStatsBean")
		.log("${body}");

	}

}
