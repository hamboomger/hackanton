package com.hamboomger.crossweb.model;

import com.hamboomger.crossweb.dao.CrosswebEventsDao;
import com.hamboomger.model.event.IEvent;
import com.hamboomger.model.parser.IEventsParser;
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
public class CrosswebEventsParser implements IEventsParser {

	private static final String CROSSWEB_EVENTS_PAGE_URL = "https://crossweb.pl/en/events/warszawa/";

	private CrosswebMainPageParser mainPageParser = new CrosswebMainPageParser();
	private CrosswebEventPageParser eventPageParser = new CrosswebEventPageParser();
	private CrosswebEventsDao eventsDao;

	@Autowired
	public CrosswebEventsParser(CrosswebEventsDao eventsDao) {
		this.eventsDao = eventsDao;
	}

	@Override
	public List<IEvent> parseEvents(boolean newOnly) throws IOException {
		List<CrosswebEventNameAndLink> eventsInfo = mainPageParser.getEventsShortInfo(CROSSWEB_EVENTS_PAGE_URL);
		List<IEvent> events = eventsInfo.stream()
				.filter(newOnlyPredicate)
				.map(parseEventByUrl)
				.collect(Collectors.toList());
		return events;
	}

	private Predicate<CrosswebEventNameAndLink> newOnlyPredicate = (eventInfo -> {
		return eventsDao.findByName(eventInfo.getName()) == null;
	});

	private Function<CrosswebEventNameAndLink, IEvent> parseEventByUrl = (eventInfo) -> {
		try {
			return eventPageParser.parse(eventInfo.getUrl());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	};

}
