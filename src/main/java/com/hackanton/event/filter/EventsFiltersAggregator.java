package com.hackanton.event.filter;

import com.hackanton.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter that aggregates a list of filters inside.
 * It's method {@link #apply(Event)} returns true only if
 * all inner filters also returns true.
 * @author ddorochov
 */
public class EventsFiltersAggregator implements IEventsFilter {

	private List<IEventsFilter> filters = new ArrayList<>();

	EventsFiltersAggregator() {}

	void addFilter(IEventsFilter filter) {
		filters.add(filter);
	}

	@Override
	public boolean apply(Event event) {
		for(IEventsFilter filter : filters)
			if (!filter.apply(event)) return false;
		return true;
	}
}
