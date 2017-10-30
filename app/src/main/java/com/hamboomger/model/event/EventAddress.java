package com.hamboomger.model.event;

/**
 * @author ddorochov
 */
public class EventAddress {
	private String city;
	private String place;
	private String fullAddress;

	public EventAddress(String city, String place, String fullAddress) {
		this.city = city;
		this.place = place;
		this.fullAddress = fullAddress;
	}

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

