package com.redhat.ukiservices.etl.factory;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.converter.jaxb.JaxbDataFormat;

@Singleton
@Named("dataFormatFactory")
public class DataFormatFactory {

	private JaxbDataFormat jaxbDataFormat;

	/**
	 * Returns an instance of a jaxbdataformat, so it is kept common across the
	 * project
	 * 
	 * @return
	 */
	public JaxbDataFormat getJaxbDataFormat(String contextPath) {

		if (jaxbDataFormat == null) {
			jaxbDataFormat = new JaxbDataFormat();
			jaxbDataFormat.setContextPath(contextPath);
			jaxbDataFormat.setMustBeJAXBElement(false);
		}
		return jaxbDataFormat;
	}

}
