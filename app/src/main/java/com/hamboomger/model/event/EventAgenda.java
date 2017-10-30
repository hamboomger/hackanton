package com.hamboomger.model.event;

import com.hamboomger.model.common.Appointment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddorochov
 */
public class EventAgenda {
	private List<Appointment> appointments;
	private String additionalInfo;

	public EventAgenda(Builder builder) {
		this.appointments = builder.appointments;
		this.additionalInfo = builder.additionalInfo.toString();
	}

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
