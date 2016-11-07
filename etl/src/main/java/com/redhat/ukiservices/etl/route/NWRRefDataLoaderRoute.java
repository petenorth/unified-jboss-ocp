package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.deltaspike.core.api.config.ConfigProperty;

import com.redhat.ukiservices.etl.factory.DataFormatFactory;

@ContextName("etlContext")
public class NWRRefDataLoaderRoute extends RouteBuilder {

	private static final String JAXB_MODEL_CONTEXTPATH = "com.redhat.ukiservices.etl.model.jaxb.ref";

	@Inject
	@ConfigProperty(name = "REFERENCE_DATA_DIRECTORY", defaultValue = "src/main/resources/ref")
	private String refDataDirPath;

	@Inject
	private DataFormatFactory dataFormatFactory;

	@Override
	public void configure() throws Exception {
		from(buildFileConsumer()).id("refDataRoute")
				.unmarshal(dataFormatFactory.getJaxbDataFormat(JAXB_MODEL_CONTEXTPATH))
				.processRef("refDataProcessor")
				.log("Reference Data refresh completed from ${in.header.CamelFileName}");

	}

	private String buildFileConsumer() {
		StringBuilder sb = new StringBuilder();
		sb.append("file");
		sb.append(":");
		sb.append(refDataDirPath);

		return sb.toString();
	}

}
