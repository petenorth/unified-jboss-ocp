package com.redhat.ukiservices.etl.process;

import java.util.List;

import javax.inject.Inject;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.Search;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;

import com.redhat.ukiservices.etl.DarwinCache;
import com.redhat.ukiservices.etl.RefDataCache;
import com.redhat.ukiservices.etl.model.common.RefDataType;
import com.redhat.ukiservices.etl.model.common.impl.DarwinDataModel;
import com.redhat.ukiservices.etl.model.common.impl.RefDataModel;

public class DataGridStatsProcessor implements Processor {

	private static final String OUTPUT_LOG_MESSAGE = "There are %d locations stored. %n There are %d messages related to Birmingham New Street";

	@Inject
	@DarwinCache
	private RemoteCache darwinCache;

	@Inject
	@RefDataCache
	private RemoteCache refDataCache;

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();

		int locations = countRefDataCacheObjects("rdType", RefDataType.LOCATION);
		int birminghamIssues = countDarwinDataCacheObjects("locations", "BHAMNWS");
		in.setBody(String.format(OUTPUT_LOG_MESSAGE, locations, birminghamIssues));

	}

	private int countRefDataCacheObjects(String field, Object term) {

		QueryFactory<Query> qf = Search.getQueryFactory(refDataCache);

		Query query = qf.from(RefDataModel.class).having(field).eq(term).toBuilder().build();

		List results = query.list();

		return results.size();
	}

	private int countDarwinDataCacheObjects(String field, Object term) {

		QueryFactory qf = Search.getQueryFactory(darwinCache);

		Query query = qf.from(DarwinDataModel.class).having(field).contains(term).toBuilder().build();

		List results = query.list();

		return results.size();
	}

}
