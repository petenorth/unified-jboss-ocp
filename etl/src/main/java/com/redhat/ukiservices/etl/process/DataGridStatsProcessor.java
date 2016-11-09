package com.redhat.ukiservices.etl.process;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.Search;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;

import com.redhat.ukiservices.etl.DarwinCache;
import com.redhat.ukiservices.model.common.impl.DarwinDataModel;


@Singleton
@Named("dgStatsProcessor")
public class DataGridStatsProcessor implements Processor {

	private static final String OUTPUT_LOG_MESSAGE = "Status Update: There are %d issues currently related to %s";

	@Inject
	@ConfigProperty(name = "ISSUE_LOCATION", defaultValue = "Birmingham New Street")
	private String issueLocation;
	
	@Inject
	@DarwinCache
	private RemoteCache<String, DarwinDataModel> darwinCache;

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		
		int issues = countDarwinDataCacheObjects("locations", issueLocation);
		in.setBody(String.format(OUTPUT_LOG_MESSAGE, issues, issueLocation));
		exchange.setIn(in);

	}

	private int countDarwinDataCacheObjects(String field, Object term) {

		QueryFactory<Query> qf = Search.getQueryFactory(darwinCache);

		Query query = qf.from(DarwinDataModel.class)
				.having(field)
				.eq(term)
				.and()
				.not(qf.having("message").isNull())
				.toBuilder().build();

		List results = query.list();

		return results.size();
	}

}
