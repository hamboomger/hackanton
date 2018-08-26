package com.hackanton.event.parsing;

import com.hackanton.event.Event;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ddorochov
 */
public interface IEventsParser {

	List<Event> parseEvents(boolean newOnly) throws IOException;

	default List<Event> parseEvents() throws IOException {
		return parseEvents(false);
	}

	default List<Event> parseEvents(boolean newOnly, List<Predicate<Event>> filters) throws IOException {
		Stream<Event> stream = parseEvents(newOnly).stream();
		for(Predicate<Event> filter : filters) {
			stream = stream.filter(filter);
		}

		return stream.collect(Collectors.toList());
	}

}
