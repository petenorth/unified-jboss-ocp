package com.redhat.ukiservices.etl.route;

import javax.inject.Inject;
import javax.xml.bind.UnmarshalException;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import com.redhat.ukiservices.etl.EtlConstants;
import com.redhat.ukiservices.etl.factory.DataFormatFactory;

import io.fabric8.annotations.Alias;
import io.fabric8.annotations.ServiceName;

@ContextName("etlContext")
public class NWRDataTransformationRoute extends RouteBuilder {

	private static final String JAXB_MODEL_CONTEXTPATH = "com.redhat.ukiservices.etl.model.jaxb";

	@Inject
	@ServiceName("broker-amq-tcp")
	@Alias("amq")
	private ActiveMQComponent activeMQComponent;

	@Inject
	private DataFormatFactory dataFormatFactory;
	

	@Override
	public void configure() throws Exception {

		onException(UnmarshalException.class)
				.log("Exception caught during transformation. Is the message the right format?");

		from("amq:queue:ingestdata")
			.id("etlRoute")
			.unmarshal(dataFormatFactory.getJaxbDataFormat(JAXB_MODEL_CONTEXTPATH))
			.split().method("pPortDataResponseSplitter", "splitDataResponse")
			.choice()
			.when(header(EtlConstants.TYPE_HEADER_KEY).isEqualTo(EtlConstants.TYPE_HEADER_TS))
				.log("Received a TrainStatus object")
				.processRef("tsDataTransformer")
				.processRef("datagridPutProcessor")
			.when(header(EtlConstants.TYPE_HEADER_KEY).isEqualTo(EtlConstants.TYPE_HEADER_OW))
				.log("Received a StationMessage object")
				.processRef("owDataTransformer")
				.processRef("datagridPutProcessor");


	}

}
