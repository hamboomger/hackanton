package com.hamboomger.model.event;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ddorochov
 */
@Embeddable
@Access(javax.persistence.AccessType.FIELD)
public class EventAgenda {

	@ElementCollection
	private List<String> appointments;

	@Column
	private String additionalInfo;

	public EventAgenda(List<String> appointments, String additionalInfo) {
		this.appointments = appointments;
		this.additionalInfo = additionalInfo;
	}

	EventAgenda(List<String> appointments) {
		this.appointments = appointments;
	}

	protected EventAgenda() {}

	public List<String> getAppointments() {
		return appointments;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

}
