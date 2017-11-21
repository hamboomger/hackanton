package com.hamboomger.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hamboomger.model.common.User;
import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ddorochov
 */
@Entity
public class EventsSearchConfiguration {

	@Id
	@GeneratedValue
	private long id;

	@ElementCollection
	private List<String> keywords;

	@ElementCollection
	private List<EventType> eventTypes;

	@Column
	private PriceType priceType;

	public EventsSearchConfiguration(List<String> keywords, List<EventType> eventTypes, PriceType priceType) {
		this.keywords = keywords;
		this.eventTypes = eventTypes;
		this.priceType = priceType;
	}

	protected EventsSearchConfiguration() {}

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
