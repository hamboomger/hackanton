package com.hamboomger.model.filter;

import com.hamboomger.model.search.EventsSearchConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ddorochov
 */
@Component
public class MainEventsFilterFactory implements IEventsFilterFactory {

	private final List<ISinglePropertyFilterFactory> filterFactories;

	@Autowired(required = false)
	public MainEventsFilterFactory(List<ISinglePropertyFilterFactory> filterFactories) {
		this.filterFactories = filterFactories;
	}

	@Override
	public IEventsFilter createFilter(EventsSearchConfiguration configuration) {
		EventsFiltersAggregator filtersAggregator = new EventsFiltersAggregator();
		for(ISinglePropertyFilterFactory factory : filterFactories) {
			IEventsFilter filter = factory.createFilter(configuration);
			if(filter != null) {
				filtersAggregator.addFilter(filter);
			}
		}

		return filtersAggregator;
	}
}
