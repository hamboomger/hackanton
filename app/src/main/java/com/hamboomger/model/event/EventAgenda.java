package com.hamboomger.model.event;

import com.hamboomger.model.common.Appointment;

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
	private List<Appointment> appointments;

	@Column
	private String additionalInfo;

	public EventAgenda(Builder builder) {
		this.appointments = builder.appointments;
		this.additionalInfo = builder.additionalInfo.toString();
	}

	protected EventAgenda() {}

	public static class Builder {
		private List<Appointment> appointments = new ArrayList<>();
		private StringBuilder additionalInfo = new StringBuilder();

		public Builder addAppointment(Appointment appointment) {
			appointments.add(appointment);
			return this;
		}

		public Builder addAdditionalInfo(String info) {
			additionalInfo.append(info).append("\n");
			return this;
		}

		public EventAgenda build() {
			return new EventAgenda(this);
		}

	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

}
