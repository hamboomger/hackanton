package com.hackanton.event.filter;

import com.hackanton.common.IWordsSearchStrategy;
import com.hackanton.event.Event;
import com.hackanton.event.EventAgenda;

import java.util.List;

import static com.hackanton.common.EntityBuildingToolkit.checkNullOrEmpty;

/**
 * @author ddorochov
 */

public class KeywordsEventsFilter implements IEventsFilter {

	private List<String> keywords;
	private IWordsSearchStrategy searchStrategy;

	KeywordsEventsFilter(List<String> keywords, IWordsSearchStrategy searchStrategy) {
		checkNullOrEmpty(keywords, "keywords");

		this.keywords = keywords;
		this.searchStrategy = searchStrategy;
	}

	@Override
	public boolean apply(Event event) {
		for(String keyword : keywords) {
			boolean eventContainsKeyword = checkInDescription(keyword, event);
			if(!eventContainsKeyword)
				eventContainsKeyword = checkInAgenda(keyword, event);

			if(!eventContainsKeyword) return false;
		}

		return true;
	}

	private boolean checkInDescription(String keyword, Event event) {
		String description = event.getDescription();
		return searchStrategy.textContains(description, keyword);
	}

	private boolean checkInAgenda(String keyword, Event event) {
		EventAgenda agenda = event.getAgenda();
		if(agenda == null) return false;

		for(String appointment : agenda.getAppointments()) {
			if(searchStrategy.textContains(appointment, keyword))
				return true;
		}

		return false;
	}

}