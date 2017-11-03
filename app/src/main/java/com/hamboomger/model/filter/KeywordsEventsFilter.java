package com.hamboomger.model.filter;

import com.hamboomger.model.common.Appointment;
import com.hamboomger.model.event.EventAgenda;
import com.hamboomger.model.event.IEvent;

import java.util.List;

import static com.hamboomger.util.EntityBuildingToolkit.*;

/**
 * @author ddorochov
 */

public class KeywordsEventsFilter implements IEventsFilter {
	private List<String> keywords;

	KeywordsEventsFilter(List<String> keywords) {
		checkNullOrEmpty(keywords, "keywords");

		this.keywords = keywords;
	}

	@Override
	public boolean apply(IEvent event) {
		for(String keyword : keywords) {
			boolean eventContainsKeyword =
					checkInDescription(keyword, event) ||
					checkInAgenda(keyword, event);

			if(!eventContainsKeyword) return false;
		}

		return true;
	}

	private boolean checkInDescription(String keyword, IEvent event) {
		String description = event.getDescription();
		return containsIgnoreCase(description, keyword);
	}

	private boolean checkInAgenda(String keyword, IEvent event) {
		EventAgenda agenda = event.getAgenda();
		if(agenda == null) return false;

		for(Appointment appointment : agenda.getAppointments()) {
			String appointmentDescription = appointment.getDescription();
			if(containsIgnoreCase(appointmentDescription, keyword))
				return true;
		}

		String additionalInfo = agenda.getAdditionalInfo();
		return containsIgnoreCase(additionalInfo, keyword);
	}

	private boolean containsIgnoreCase(String sourceString, String targetString) {
		return sourceString.toLowerCase().contains(targetString.toLowerCase());
	}

}