package com.hamboomger.model.search;

import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;

import java.util.List;

/**
 * @author ddorochov
 */
public class EventsSearchConfiguration {
	private List<String> keywords;
	private List<EventType> eventTypes;
	private PriceType priceType;

	public EventsSearchConfiguration(List<String> keywords, List<EventType> eventTypes, PriceType priceType) {
		this.keywords = keywords;
		this.eventTypes = eventTypes;
		this.priceType = priceType;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public List<EventType> getEventTypes() {
		return eventTypes;
	}

	public PriceType getPriceType() {
		return priceType;
	}
}
