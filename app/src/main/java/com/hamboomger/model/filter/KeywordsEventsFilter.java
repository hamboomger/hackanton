package com.hamboomger.model.filter;

import com.hamboomger.model.common.Appointment;
import com.hamboomger.model.common.IWordsSearchStrategy;
import com.hamboomger.model.event.EventAgenda;
import com.hamboomger.model.event.IEvent;

import java.util.List;

import static com.hamboomger.util.EntityBuildingToolkit.checkNullOrEmpty;

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
	public boolean apply(IEvent event) {
		for(String keyword : keywords) {
			boolean eventContainsKeyword = checkInDescription(keyword, event);
			if(!eventContainsKeyword)
				eventContainsKeyword = checkInAgenda(keyword, event);

			if(!eventContainsKeyword) return false;
		}

		return true;
	}

	private boolean checkInDescription(String keyword, IEvent event) {
		String description = event.getDescription();
		return searchStrategy.textContains(description, keyword);
	}

	private boolean checkInAgenda(String keyword, IEvent event) {
		EventAgenda agenda = event.getAgenda();
		if(agenda == null) return false;

		for(Appointment appointment : agenda.getAppointments()) {
			String appointmentDescription = appointment.getDescription();
			if(searchStrategy.textContains(appointmentDescription, keyword))
				return true;
		}

		String additionalInfo = agenda.getAdditionalInfo();
		return searchStrategy.textContains(additionalInfo, keyword);
	}

}