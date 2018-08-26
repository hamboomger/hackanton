package com.hackanton.crossweb.scrapping;

import com.hackanton.crossweb.event.CrosswebEventsDao;
import com.hackanton.crossweb.parsing.CrosswebEventNameAndLink;
import com.hackanton.crossweb.parsing.CrosswebEventPageParser;
import com.hackanton.crossweb.parsing.CrosswebMainPageParser;
import com.hackanton.event.Event;
import com.hackanton.event.filter.EventFilterService;
import com.hackanton.event.filter.IEventsFilter;
import com.hackanton.user.ICurrentUserProvider;
import com.hackanton.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author ddorochov
 */
@Service
public class CrosswebScannerService {

	private static final String CROSSWEB_EVENTS_PAGE_URL = "https://crossweb.pl/en/events/warszawa/";

	private final EventFilterService eventsFiltersService;
	private final ICurrentUserProvider currentUserProvider;
	private CrosswebEventsDao eventsDao;

	private CrosswebMainPageParser mainPageParser = new CrosswebMainPageParser();
	private CrosswebEventPageParser eventPageParser = new CrosswebEventPageParser();

	@Autowired
	public CrosswebScannerService(EventFilterService eventsFiltersService,
								  ICurrentUserProvider currentUserProvider,
								  CrosswebEventsDao eventsDao) {
		this.eventsFiltersService = eventsFiltersService;
		this.currentUserProvider = currentUserProvider;
		this.eventsDao = eventsDao;
	}

	public synchronized List<Event> scanNewEvents() throws IOException {
		User user = currentUserProvider.getCurrentUser();

		List<CrosswebEventNameAndLink> eventsInfo = mainPageParser.getEventsShortInfo(CROSSWEB_EVENTS_PAGE_URL);
		List<Event> events =  eventsInfo.stream()
				.filter(newOnlyPredicate)
				.map(parseEventByUrlMapper)
				.collect(Collectors.toList());

		return (user != null) ?
				filterEventsByUserConfiguration(user, events) : events;
	}

	private Predicate<CrosswebEventNameAndLink> newOnlyPredicate = (eventInfo ->
			eventsDao.findByName(eventInfo.getName()) == null
	);

	private Function<CrosswebEventNameAndLink, Event> parseEventByUrlMapper = (eventInfo) -> {
		try {
			return eventPageParser.parse(eventInfo.getUrl());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	};

	private List<Event> filterEventsByUserConfiguration(User user, List<Event> events) {
		IEventsFilter filter = eventsFiltersService.createFilter(user.getSearchConfiguration());
		return events.stream()
				.filter(filter::apply)
				.collect(Collectors.toList());
	}

}
