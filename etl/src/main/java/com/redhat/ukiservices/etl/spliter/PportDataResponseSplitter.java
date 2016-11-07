package com.redhat.ukiservices.etl.spliter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.etl.EtlConstants;
import com.redhat.ukiservices.etl.model.jaxb.Pport;
import com.redhat.ukiservices.etl.model.jaxb.Pport.UR;
import com.redhat.ukiservices.etl.model.jaxb.StationMessage;
import com.redhat.ukiservices.etl.model.jaxb.TS;


@Singleton
@Named("pPortDataResponseSplitter")
public class PportDataResponseSplitter {

	private static final String PAYLOAD_LOG_MESSAGE = "Added %s paylod for id: %s";
	private static final Logger LOG = LoggerFactory.getLogger(PportDataResponseSplitter.class);

	/**
	 * Custom split which removes the objects in the pport we're interested in,
	 * and generates new messages from thos objects
	 * 
	 * @param old
	 *            The original message.
	 * @return a list of messages
	 */
	public List<Message> splitDataResponse(Message old) {

		List<Message> dataResponses = new ArrayList<>();

		Pport port = (Pport) old.getBody();
		UR ur = port.getUR();

		if (ur != null) {

			if (!ur.getTS().isEmpty()) {

				for (TS ts : ur.getTS()) {
					Map<String, Object> headers = new HashMap<>();
					headers.put(EtlConstants.TYPE_HEADER_KEY, EtlConstants.TYPE_HEADER_TS);

					dataResponses.add(createMessage(ts, headers));
					LOG.debug(String.format(PAYLOAD_LOG_MESSAGE, EtlConstants.TYPE_HEADER_TS, ts.getUid()));
				}
			}

			if (!ur.getOW().isEmpty()) {

				for (StationMessage ow : ur.getOW()) {
					Map<String, Object> headers = new HashMap<>();
					headers.put(EtlConstants.TYPE_HEADER_KEY, EtlConstants.TYPE_HEADER_OW);

					dataResponses.add(createMessage(ow, headers));
					LOG.debug(String.format(PAYLOAD_LOG_MESSAGE, EtlConstants.TYPE_HEADER_OW,
							String.valueOf(ow.getId())));
				}
			}
		}

		return dataResponses;
	}

	/**
	 * Generic private method to take a payload and wrap it into a message
	 * 
	 * @param object
	 * @param headers
	 * @return a wrapped payload
	 */
	private <T> DefaultMessage createMessage(T object, Map<String, Object> headers) {
		DefaultMessage message = new DefaultMessage();

		message.setBody(object);
		message.setHeaders(headers);

		return message;
	}
}
