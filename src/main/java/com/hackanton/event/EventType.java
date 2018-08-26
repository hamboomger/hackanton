package com.hackanton.event;

/**
 * @author ddorochov
 */
public enum EventType {
	HACKATHON, MEETUP, SEMINAR, WORKSHOP,
	JOB_FAIRS, TRAINING, CONFERENCE, OTHER;

	@Override
	public String toString() {
		String lowerCase = super.toString().toLowerCase();
		char firstLetter = lowerCase.charAt(0);
		return Character.toUpperCase(firstLetter) + lowerCase.substring(1);
	}
}
