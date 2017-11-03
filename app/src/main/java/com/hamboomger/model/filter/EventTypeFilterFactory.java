package com.hamboomger.model.filter;

import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.IEvent;
import com.hamboomger.model.search.EventsSearchConfiguration;
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

		public EventTypeFilter(List<EventType> eventTypes) {
			this.eventTypes = eventTypes;
		}

		@Override
		public boolean apply(IEvent event) {
			EventType eventType = event.getType();
			return eventTypes.contains(eventType);
		}
	}
}
