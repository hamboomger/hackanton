package com.hamboomger.model.event

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalTime

/**
 * @author ddorochov
 */
class EventAgendaTest {
    @Test fun testAssembling() {
        // arrange
        val midnightAppointment = Appointment(LocalTime.MIDNIGHT, "Midnight event")
        val noonAppointment = Appointment(LocalTime.NOON, "Noon event")

        // act
        val builder = EventAgenda.Builder()
                .addAppointment(midnightAppointment)
                .addAppointment(noonAppointment)
                .addAdditionalInfo("A")
                .addAdditionalInfo("B")
                .addAdditionalInfo("C")
        val agenda = builder.build()

        // assert
        assertTrue(agenda.additionalInfo == "A\nB\nC\n")
        assertTrue(agenda.appointments.size == 2)
    }
}