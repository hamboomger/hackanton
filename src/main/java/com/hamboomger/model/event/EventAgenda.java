package com.hamboomger.model.event;

import javax.persistence.Access;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

/**
 * @author ddorochov
 */
@Embeddable
@Access(javax.persistence.AccessType.FIELD)
public class EventAgenda {

	@ElementCollection
	private List<String> appointments;

	public EventAgenda(List<String> appointments) {
		this.appointments = appointments;
	}

	protected EventAgenda() {}

	public List<String> getAppointments() {
		return appointments;
	}

}
