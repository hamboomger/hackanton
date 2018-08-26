package com.hackanton.model.event;

import com.hackanton.crossweb.event.CrosswebEvent;
import com.hackanton.event.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class EventMocks {
	public static Event getMock1() {
		EventAgenda eventAgenda = new EventAgenda(
				Arrays.asList("Some appointment", "Another appointment")
		);

		List<String> topics = Arrays.asList("First topic", "Second topic");

		return new CrosswebEvent.Builder()
				.setName("Great event")
				.setDescription("Event description")
				.setAddress(new EventAddress("Warsaw", "Warsaw Spire", "al. Jerozolimskie"))
				.setAgenda(eventAgenda)
				.setDateAndTime(LocalDateTime.now())
				.setPageUrl("http://mockurl.com")
				.setLanguage(Language.ENGLISH)
				.setPriceType(PriceType.FREE)
				.setTopics(topics)
				.setType(EventType.MEETUP)
				.build();
	}

	public static Event getMock2() {
		EventAgenda eventAgenda = new EventAgenda(
				Arrays.asList("First appointment", "Second appointment")
		);

		List<String> topics = Arrays.asList("Javascript", "Scala");

		return new CrosswebEvent.Builder()
				.setName("Awesome Kotlin event about reflection")
				.setDescription("You gonna like it, for sure.")				.setAddress(new EventAddress("Warsaw", "Warsaw Spire", "al. Jerozolimskie"))
				.setAgenda(eventAgenda)
				.setDateAndTime(LocalDateTime.now())
				.setPageUrl("http://mockurl.com")
				.setLanguage(Language.ENGLISH)
				.setPriceType(PriceType.FREE)
				.setTopics(topics)
				.setType(EventType.CONFERENCE)
				.build();
	}
}
