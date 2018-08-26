package com.hackanton.event.filter;

import com.hackanton.event.EventsSearchConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddorochov
 */
@Service
public class EventFilterService {

	private final List<ISinglePropertyFilterFactory> filterFactories;

	@Autowired(required = false)
	public EventFilterService(List<ISinglePropertyFilterFactory> filterFactories) {
		this.filterFactories = filterFactories;
	}

	public EventFilterService() {
		this.filterFactories = new ArrayList<>();
	}

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
