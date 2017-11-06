package com.hamboomger.model.search;

import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author ddorochov
 */
@Entity
public class EventsSearchConfiguration {

	@Id
	private String username;

	@ElementCollection
	private List<String> keywords;

	@ElementCollection
	private List<EventType> eventTypes;

	@Column
	private PriceType priceType;

	public EventsSearchConfiguration(String username, List<String> keywords,
									 List<EventType> eventTypes, PriceType priceType) {
		this.username = username;
		this.keywords = keywords;
		this.eventTypes = eventTypes;
		this.priceType = priceType;
	}

	protected EventsSearchConfiguration() {}

	public String getUsername() {
		return username;
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
