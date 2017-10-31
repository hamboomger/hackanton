package com.hamboomger.model.event;

import com.hamboomger.model.common.Appointment;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author ddorochov
 */
public class EventAgendaTest {
	@Test
	public void testAssembling() {
		// arrange
		Appointment midnightAppointment = new Appointment(LocalTime.MIDNIGHT, "Midnight event");
		Appointment noonAppointment = new Appointment(LocalTime.NOON, "Noon event");

		// act
		EventAgenda.Builder builder = new EventAgenda.Builder()
				.addAppointment(midnightAppointment)
				.addAppointment(noonAppointment)
				.addAdditionalInfo("A")
				.addAdditionalInfo("B")
				.addAdditionalInfo("C");

		EventAgenda agenda = builder.build();

		// assert
		assertThat(agenda.getAdditionalInfo(),
				is("A\nB\nC\n"));
		assertThat(agenda.getAppointments().size(),
				is(2));
	}
}
