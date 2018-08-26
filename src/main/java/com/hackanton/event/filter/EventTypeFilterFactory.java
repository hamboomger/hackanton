package com.hackanton.event.filter;

import com.hackanton.event.Event;
import com.hackanton.event.EventType;
import com.hackanton.event.EventsSearchConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ddorochov
 */
@Component
public class EventTypeFilterFactory implements ISinglePropertyFilterFactory {

	@Override
	public IEventsFilter createFilter(EventsSearchConfiguration configuration) {
		List<EventType> eventTypes = configuration.getEventTypes();

		if (eventTypes == null || eventTypes.isEmpty())
			return null;
		else
			return new EventTypeFilter(eventTypes);
	}

	public class EventTypeFilter implements IEventsFilter {

		private final List<EventType> eventTypes;

		EventTypeFilter(List<EventType> eventTypes) {
			this.eventTypes = eventTypes;
		}

		@Override
		public boolean apply(Event event) {
			EventType eventType = event.getType();
			return eventTypes.contains(eventType);
		}
	}
}
