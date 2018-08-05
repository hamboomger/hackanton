package com.hackanton.crossweb;

import com.hackanton.crossweb.parsing.CrosswebEventsParser;
import com.hackanton.event.IEvent;
import com.hackanton.event.filter.IEventsFilter;
import com.hackanton.event.filter.MainEventsFilterFactory;
import com.hackanton.user.ICurrentUserProvider;
import com.hackanton.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ddorochov
 */
@Service
public class CrosswebScannerService {

	private final CrosswebEventsParser eventsParser;
	private final MainEventsFilterFactory filterFactory;
	private final ICurrentUserProvider currentUserProvider;

	@Autowired
	public CrosswebScannerService(CrosswebEventsParser eventsParser, MainEventsFilterFactory filterFactory,
								  ICurrentUserProvider currentUserProvider) {
		this.eventsParser = eventsParser;
		this.filterFactory = filterFactory;
		this.currentUserProvider = currentUserProvider;
	}

	public synchronized List<IEvent> scanEvents(boolean newOnly) throws IOException {
		User user = currentUserProvider.getCurrentUser();

		List<IEvent> events = eventsParser.parseEvents(newOnly);
		return (user != null) ?
				filterEventsByUserConfiguration(user, events) : events;
	}

	private List<IEvent> filterEventsByUserConfiguration(User user, List<IEvent> events) {
		IEventsFilter filter = filterFactory.createFilter(user.getSearchConfiguration());
		return events.stream()
				.filter(filter::apply)
				.collect(Collectors.toList());
	}

}
