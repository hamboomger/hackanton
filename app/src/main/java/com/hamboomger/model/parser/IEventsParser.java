package com.hamboomger.model.parser;

import com.hamboomger.model.event.IEvent;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ddorochov
 */
public interface IEventsParser {

	List<IEvent> parseEvents(boolean newOnly) throws IOException;

	default List<IEvent> parseEvents() throws IOException {
		return parseEvents(false);
	};

	default List<IEvent> parseEvents(boolean newOnly, List<Predicate<IEvent>> filters) throws IOException {
		Stream<IEvent> stream = parseEvents(newOnly).stream();
		for(Predicate<IEvent> filter : filters) {
			stream = stream.filter(filter);
		}

		return stream.collect(Collectors.toList());
	}

}
