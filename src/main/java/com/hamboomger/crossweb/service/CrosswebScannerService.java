package com.hamboomger.crossweb.service;

import com.hamboomger.crossweb.model.CrosswebEventsParser;
import com.hamboomger.model.common.User;
import com.hamboomger.model.event.IEvent;
import com.hamboomger.model.filter.IEventsFilter;
import com.hamboomger.model.filter.MainEventsFilterFactory;
import com.hamboomger.web.auth.ICurrentUserProvider;
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
