package com.hamboomger.model.search;

import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
		this.keywords = new ArrayList<>(keywords);
		this.eventTypes = new ArrayList<>(eventTypes);
		this.priceType = priceType;
	}

	protected EventsSearchConfiguration() {}

	public List<String> getKeywords() {
		return keywords;
	}

	public void addKeyword(String keyword) {
		if(!keywords.contains(keyword)) {
			keywords.add(keyword);
		}
	}

	public void deleteKeyword(String keyword) {
		if(keywords.contains(keyword)) {
			keywords.remove(keyword);
		}
	}

	public List<EventType> getEventTypes() {
		return eventTypes;
	}

	public PriceType getPriceType() {
		return priceType;
	}

}
