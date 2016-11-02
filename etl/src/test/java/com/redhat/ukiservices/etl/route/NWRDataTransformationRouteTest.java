package com.redhat.ukiservices.etl.route;

import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Ignore;
import org.junit.Test;

import com.redhat.ukiservices.etl.factory.DataFormatFactory;
import com.redhat.ukiservices.etl.process.DataGridPreProcessor;

public class NWRDataTransformationRouteTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {

		NWRDataTransformationRoute route = new NWRDataTransformationRoute();
		return route;

	}

	@Override
	protected JndiRegistry createRegistry() throws Exception {
		JndiRegistry jndi = super.createRegistry();

		jndi.bind("dataFormatFactory", new DataFormatFactory());
		jndi.bind("datagridPreProcessor", new DataGridPreProcessor());

		return jndi;
	}

	@Test
	@Ignore
	public void testTransformation() throws Exception {

		context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceRouteFromWith("etlRoute", "file:src/data");
				mockEndpoints();
			}
		});

		getMockEndpoint("infinispan://datagrid-app").expectedMessageCount(4);

		context.start();

	}

}
