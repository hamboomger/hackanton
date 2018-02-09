package com.hamboomger.model.event;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
		assertThat(agenda.getAdditionalInfo(),
				is("A\nB\nC\n"));
		assertThat(agenda.getAppointments().size(),
				is(2));
	}
}
