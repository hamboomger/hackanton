package com.hamboomger.model.filter;

import com.hamboomger.model.event.IEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter that aggregates a list of filters inside.
 * It's method {@link #apply(IEvent)} returns true only if
 * all inner filters also returns true.
 * @author ddorochov
 */
public class EventsFiltersAggregator implements IEventsFilter {

	private List<IEventsFilter> filters = new ArrayList<>();

	public EventsFiltersAggregator() {}

	public void addFilter(IEventsFilter filter) {
		filters.add(filter);
	}

	@Override
	public boolean apply(IEvent event) {
		for(IEventsFilter filter : filters)
			if (!filter.apply(event)) return false;
		return true;
	}
}
