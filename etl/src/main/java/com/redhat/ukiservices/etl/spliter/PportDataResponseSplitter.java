package com.redhat.ukiservices.etl.spliter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Message;
import org.apache.camel.component.infinispan.InfinispanConstants;
import org.apache.camel.impl.DefaultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.ukiservices.etl.EtlConstants;
import com.redhat.ukiservices.etl.model.Pport;
import com.redhat.ukiservices.etl.model.Pport.UR;
import com.redhat.ukiservices.etl.model.StationMessage;
import com.redhat.ukiservices.etl.model.TS;

@Singleton
@Named("pPortDataResponseSplitter")
public class PportDataResponseSplitter {

	/**
	 * Custom split which removes the objects in the pport we're interested in,
	 * and generates new messages from thos objects
	 * 
	 * @param old
	 *            The original message.
	 * @return a list of messages
	 */
	public List<Message> splitDataResponse(Message old) {

		final Logger LOG = LoggerFactory.getLogger(this.getClass());

		List<Message> dataResponses = new ArrayList<>();

		Pport port = (Pport) old.getBody();
		UR ur = port.getUR();

		if (ur != null) {

			if (!ur.getTS().isEmpty()) {

				for (TS ts : ur.getTS()) {
					Map<String, Object> headers = new HashMap<>();
					headers.put(EtlConstants.TYPE_HEADER_KEY, EtlConstants.TYPE_HEADER_TS);
					headers.put(InfinispanConstants.KEY, ts.getUid());

					dataResponses.add(createMessage(ts, headers));
					LOG.info("Added TS Payload");
				}
			}

			if (!ur.getOW().isEmpty()) {

				for (StationMessage ow : ur.getOW()) {
					Map<String, Object> headers = new HashMap<>();
					headers.put(EtlConstants.TYPE_HEADER_KEY, EtlConstants.TYPE_HEADER_OW);
					headers.put(InfinispanConstants.KEY, ow.getId());

					dataResponses.add(createMessage(ow, headers));
					LOG.info("Added StationMessage Payload");
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
