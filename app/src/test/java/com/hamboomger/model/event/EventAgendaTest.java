package com.hamboomger.model.event;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author ddorochov
 */
public class EventAgendaTest {
	@Test
	public void testAssembling() {
		// arrange
		String midnightAppointment = "Midnight event";
		String noonAppointment = "Noon event";

		// act
		EventAgenda agenda = new EventAgenda(Arrays.asList(midnightAppointment, noonAppointment));

		// assert
		assertThat(agenda.getAppointments().size(),
				is(2));
	}
}
