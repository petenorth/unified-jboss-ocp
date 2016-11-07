package com.redhat.ukiservices.etl.factory;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.converter.jaxb.JaxbDataFormat;

@Singleton
@Named("dataFormatFactory")
public class DataFormatFactory {

	/**
	 * Returns an instance of a jaxbdataformat, so it is kept common across the
	 * project
	 * 
	 * @return
	 */
	public synchronized JaxbDataFormat getJaxbDataFormat(String contextPath) {

		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		jaxbDataFormat.setContextPath(contextPath);
		jaxbDataFormat.setMustBeJAXBElement(false);
		return jaxbDataFormat;
	}

}
