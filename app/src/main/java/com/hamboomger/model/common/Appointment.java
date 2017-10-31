package com.hamboomger.model.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

/**
 * @author ddorochov
 */
@Embeddable
@Access(AccessType.FIELD)
public class Appointment {

	@Column
	private LocalTime time;

	@Column
	private String description;

	public Appointment(LocalTime time, String description) {
		this.time = time;
		this.description = description;
	}

	protected Appointment() {}

	public LocalTime getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}

}
