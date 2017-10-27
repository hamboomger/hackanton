package com.hamboomger.model.event

import java.time.LocalTime

/**
 * @author ddorochov
 */
class EventAgenda private constructor(builder: Builder) {
    val appointments : List<Appointment>
    val additionalInfo : String

    class Builder {
        val appointments = mutableListOf<Appointment>()
        val additionalInfo = StringBuilder()

        fun addAppointment(startTime: LocalTime, description: String) {
            appointments.add(Appointment(startTime, description))
        }

        fun addAdditionalInfo(info : String) {
            additionalInfo.appendln(info)
        }

        fun build() : EventAgenda = EventAgenda(this)
    }

    init {
        this.appointments = builder.appointments
        this.additionalInfo = builder.additionalInfo.toString()
    }

}

class Appointment(val startTime : LocalTime, val description: String)