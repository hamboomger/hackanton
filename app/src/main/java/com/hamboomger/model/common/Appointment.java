package com.hamboomger.model.common;

import java.time.LocalTime;

/**
 * @author ddorochov
 */
public class Appointment {
	private LocalTime time;
	private String description;

	public Appointment(LocalTime time, String description) {
		this.time = time;
		this.description = description;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}

}
