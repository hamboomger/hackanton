package com.hamboomger.model.event;

import javax.persistence.Access;
import javax.persistence.Embeddable;

/**
 * @author ddorochov
 */
@Embeddable
@Access(javax.persistence.AccessType.FIELD)
public class EventAddress {
	private String city;
	private String place;
	private String fullAddress;

	public EventAddress(String city, String place, String fullAddress) {
		this.city = city;
		this.place = place;
		this.fullAddress = fullAddress;
	}

	protected EventAddress() {}

	public String getCity() {
		return city;
	}

	public String getPlace() {
		return place;
	}

	public String getFullAddress() {
		return fullAddress;
	}
}

